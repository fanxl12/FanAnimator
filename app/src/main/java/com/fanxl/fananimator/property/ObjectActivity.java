package com.fanxl.fananimator.property;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.fanxl.fananimator.R;
import com.fanxl.fananimator.property.evaluator.CharEvaluator;

import static android.animation.ObjectAnimator.ofFloat;

/**
 * Created by fanxl2 on 2016/11/25.
 */

public class ObjectActivity extends AppCompatActivity implements View.OnClickListener {

	private TextView object_tv;

	private Button menu, item1, item2, item3, item4, item5;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_object);

		object_tv = (TextView) findViewById(R.id.object_tv);
		findViewById(R.id.object_bt_start).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
//				startPropertyValuesHolder();
//				startPropertyChart();

//				startKeyframe();

				startObjectAnimator();
			}
		});

		init();
	}

	private void init() {
		menu = (Button) findViewById(R.id.menu);
		item1 = (Button) findViewById(R.id.item1);
		item2 = (Button) findViewById(R.id.item2);
		item3 = (Button) findViewById(R.id.item3);
		item4 = (Button) findViewById(R.id.item4);
		item5 = (Button) findViewById(R.id.item5);

		menu.setOnClickListener(this);
		item2.setOnClickListener(this);
		item3.setOnClickListener(this);
		item4.setOnClickListener(this);
		item1.setOnClickListener(this);
		item5.setOnClickListener(this);
	}

	private void startObjectAnimator(){
		ObjectAnimator alpha = ofFloat(object_tv, "alpha", 1, 0);
//		alpha.setDuration(600);

		ObjectAnimator translationY = ofFloat(object_tv, "translationY", 0, 300);
//		translationY.setDuration(600);

//		alpha.start();
//		translationY.start();

		//动画一起执行
		AnimatorSet set = new AnimatorSet();
		set.playTogether(alpha, translationY);
		set.setDuration(600);
		set.setInterpolator(new AccelerateInterpolator());
		set.start();


	}

	private void startPropertyValuesHolder(){
		PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 1, 0);
		PropertyValuesHolder translationY = PropertyValuesHolder.ofFloat("translationY", 0, 600);

		ObjectAnimator object = ObjectAnimator.ofPropertyValuesHolder(object_tv, alpha, translationY);
		object.setDuration(600);
		object.start();
	}

	private void startPropertyChart(){
		//这里TextView setText() 接收的是String char类型的不能直接接收
		PropertyValuesHolder chartProperty = PropertyValuesHolder.ofObject("text", new CharEvaluator(), new Character('A'), new Character('Z'));

		ObjectAnimator object = ObjectAnimator.ofPropertyValuesHolder(object_tv, chartProperty);
		object.setDuration(6000);
		object.start();
	}

	private void startKeyframe(){

		//帧数 帧数2设置差值器是作用于帧数1到帧数2直接的动画，所以帧数1设置差值器是没有效果的，因为它就是第一帧

		Keyframe fragme1 = Keyframe.ofFloat(0, 0);
		Keyframe fragme2 = Keyframe.ofFloat(0.25f, 300);
		fragme2.setInterpolator(new AccelerateInterpolator());

		Keyframe fragme3 = Keyframe.ofFloat(0.5f, 50);
		Keyframe fragme4 = Keyframe.ofFloat(0.75f, 300);
		Keyframe fragme5 = Keyframe.ofFloat(1f, 600);

		PropertyValuesHolder translationY = PropertyValuesHolder.ofKeyframe("translationY", fragme1, fragme2, fragme3, fragme4, fragme5);
		ObjectAnimator object = ObjectAnimator.ofPropertyValuesHolder(object_tv, translationY);
		object.setDuration(1000);
		object.start();

	}

	private boolean isClose = true;

	public static final int MENU_RADIUS = 600;

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.menu:

				menuClick();

				break;
			case R.id.item1:
				menuItemClick(item1);
				break;
			case R.id.item2:
				menuItemClick(item2);
				break;
			case R.id.item3:
				menuItemClick(item3);
				break;
			case R.id.item4:
				menuItemClick(item4);
				break;
			case R.id.item5:
				menuItemClick(item5);
				break;
		}
	}

	private void menuItemClick(final View view){
		view.animate().scaleX(30).scaleY(30).setDuration(600).setListener(new Animator.AnimatorListener() {
			@Override
			public void onAnimationStart(Animator animation) {

			}

			@Override
			public void onAnimationEnd(Animator animation) {
				view.setVisibility(View.GONE);
				menuClick();
			}

			@Override
			public void onAnimationCancel(Animator animation) {

			}

			@Override
			public void onAnimationRepeat(Animator animation) {

			}
		}).start();
	}

	private void menuClick() {
		if (isClose){
			isClose = false;

			Animator animator = ObjectAnimator.ofFloat(menu, "Rotation", 0, 135);
			animator.setDuration(600);
			animator.start();

			doAnimateOpen(item1, 0);
			doAnimateOpen(item2, 1);
			doAnimateOpen(item3, 2);
			doAnimateOpen(item4, 3);
			doAnimateOpen(item5, 4);

		}else {

			Animator animator = ObjectAnimator.ofFloat(menu, "Rotation", 135, 0);
			animator.setDuration(600);
			animator.start();

			isClose = true;
			doAnimateClose(item1, 0);
			doAnimateClose(item2, 1);
			doAnimateClose(item3, 2);
			doAnimateClose(item4, 3);
			doAnimateClose(item5, 4);
		}
	}

	private void doAnimateOpen(final View view, int index) {

		double degree = Math.toRadians(90)/4 * index;
		int translationX = -(int) (MENU_RADIUS*Math.sin(degree));
		int translationY = -(int) (MENU_RADIUS*Math.cos(degree));

		AnimatorSet set = new AnimatorSet();

		set.playTogether(ofFloat(view, "translationX", 0, translationX),
				ofFloat(view, "translationY", 0, translationY),
				ofFloat(view, "alpha", 0, 1),
				ofFloat(view, "scaleX", 0, 1),
				ofFloat(view, "scaleY", 0, 1));
		set.setDuration(600);
		set.setStartDelay(50*index);
		set.addListener(new Animator.AnimatorListener() {
			@Override
			public void onAnimationStart(Animator animation) {
				if (view.getVisibility() != View.VISIBLE) {
					view.setVisibility(View.VISIBLE);
				}
			}

			@Override
			public void onAnimationEnd(Animator animation) {

			}

			@Override
			public void onAnimationCancel(Animator animation) {

			}

			@Override
			public void onAnimationRepeat(Animator animation) {

			}
		});
		set.start();
	}

	private void doAnimateClose(final View view, int index){
//		if (view.getVisibility() != View.VISIBLE) {
//			view.setVisibility(View.VISIBLE);
//		}
//		double degree = Math.toRadians(90)/4 * index;
		double degree = Math.PI * index / (4 * 2);

		int translationX = -(int) (MENU_RADIUS*Math.sin(degree));
		int translationY = -(int) (MENU_RADIUS*Math.cos(degree));

		AnimatorSet set = new AnimatorSet();
		set.playTogether(ofFloat(view, "translationX", translationX, 0),
				ofFloat(view, "translationY", translationY, 0),
				ofFloat(view, "alpha", 1, 0),
				ofFloat(view, "scaleX", 1, 0),
				ofFloat(view, "scaleY", 1, 0));
		set.addListener(new Animator.AnimatorListener() {
			@Override
			public void onAnimationStart(Animator animation) {

			}

			@Override
			public void onAnimationEnd(Animator animation) {
				view.setVisibility(View.GONE);
			}

			@Override
			public void onAnimationCancel(Animator animation) {

			}

			@Override
			public void onAnimationRepeat(Animator animation) {

			}
		});
		set.setDuration(600);
		set.start();

	}
}
