package com.fanxl.fananimator.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fanxl.fananimator.R;

/**
 * Created by fanxl2 on 2016/11/23.
 */

public class TranslateActivity extends AppCompatActivity {

	static {
		AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
	}

	private Animation translateAnim;

	private AppCompatImageView map_iv_hand, map_iv_metro, map_iv_school, map_icon_location;

	private AppCompatImageView main_iv_hand, main_iv_metro, main_iv_school, main_iv_location;

	private View map_line_one, map_line_two, map_line_three;

	private LinearLayout map_ll_tool;

	private int maxHeight, minHeight;

	private TextView anim_tv;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_translate);

		map_iv_hand = (AppCompatImageView) findViewById(R.id.map_iv_hand);
		map_iv_metro = (AppCompatImageView) findViewById(R.id.map_iv_metro);
		map_iv_school = (AppCompatImageView) findViewById(R.id.map_iv_school);
		map_icon_location = (AppCompatImageView) findViewById(R.id.map_icon_location);

		main_iv_location = (AppCompatImageView) findViewById(R.id.main_iv_location);
		main_iv_hand = (AppCompatImageView) findViewById(R.id.main_iv_hand);
		main_iv_metro = (AppCompatImageView) findViewById(R.id.main_iv_metro);
		main_iv_school = (AppCompatImageView) findViewById(R.id.main_iv_school);
		map_ll_tool = (LinearLayout) findViewById(R.id.map_ll_tool);

		main_iv_hand.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (maxHeight==0){
					maxHeight = map_ll_tool.getMeasuredHeight();
					minHeight = maxHeight/4;
				}

				startAnimation(map_ll_tool);
			}
		});

		map_line_one = findViewById(R.id.map_line_one);
		map_line_two = findViewById(R.id.map_line_two);
		map_line_three = findViewById(R.id.map_line_three);

		map_iv_hand.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				test();
			}
		});

		map_icon_location.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				back();
			}
		});

		findViewById(R.id.bt_anim_start).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				translateAnim = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0,
						Animation.RELATIVE_TO_PARENT, 0f,
						Animation.RELATIVE_TO_PARENT, 0.2f,
						Animation.RELATIVE_TO_PARENT, 0.8f);

				translateAnim.setDuration(1000);
				translateAnim.setFillAfter(true);
				translateAnim.setInterpolator(new AnticipateOvershootInterpolator());
				anim_tv.startAnimation(translateAnim);
			}
		});

		anim_tv = (TextView) findViewById(R.id.anim_tv);
	}

	private boolean isShow = true;

	private void startAnimation(final LinearLayout view) {
		ValueAnimator animator;
		if (isShow){
			animator = ValueAnimator.ofInt(maxHeight, minHeight);
		}else {
			animator = ValueAnimator.ofInt(minHeight, maxHeight);
		}

		animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				int value = (int) animation.getAnimatedValue();
				RelativeLayout.LayoutParams param = (RelativeLayout.LayoutParams) view.getLayoutParams();
				param.height = value;
				view.setLayoutParams(param);
			}
		});
		animator.addListener(new Animator.AnimatorListener() {
			@Override
			public void onAnimationStart(Animator animation) {
				if (isShow){

				}else {
					main_iv_hand.setImageResource(R.drawable.icon_map_hand);
					main_iv_location.setVisibility(View.VISIBLE);
					main_iv_metro.setVisibility(View.VISIBLE);
					main_iv_school.setVisibility(View.VISIBLE);
				}
			}

			@Override
			public void onAnimationEnd(Animator animation) {
				if (isShow){
					main_iv_location.setVisibility(View.GONE);
					main_iv_metro.setVisibility(View.GONE);
					main_iv_school.setVisibility(View.GONE);
					main_iv_hand.setImageResource(R.drawable.ic_close_white_24dp);
					isShow = false;
				}else {
					isShow = true;
				}
			}

			@Override
			public void onAnimationCancel(Animator animation) {

			}

			@Override
			public void onAnimationRepeat(Animator animation) {

			}
		});
		animator.setInterpolator(new AccelerateInterpolator());
		animator.setDuration(400);
		animator.start();
	}





	private void back() {
		map_iv_hand.setVisibility(View.VISIBLE);
		map_iv_metro.setVisibility(View.VISIBLE);
		map_iv_school.setVisibility(View.VISIBLE);
		translateAnim = new TranslateAnimation(0, 0, 531, 0);
		translateAnim.setDuration(500);
		translateAnim.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
		map_iv_hand.startAnimation(translateAnim);

		Animation translateAnim1 = new TranslateAnimation(0, 0, 354, 0);
		translateAnim1.setDuration(300);
		translateAnim1.setStartOffset(200);
		translateAnim1.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
		map_iv_metro.startAnimation(translateAnim1);

		Animation translateAnim2 = new TranslateAnimation(0, 0, 177, 0);
		translateAnim2.setDuration(100);
		translateAnim2.setStartOffset(400);
		translateAnim2.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				map_icon_location.setImageResource(R.drawable.icon_map_location);
				map_icon_location.setBackgroundResource(R.drawable.ic_map_location_bg);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
		map_iv_school.startAnimation(translateAnim2);
	}

	private int endX, endY;

	private void test(){
		translateAnim = new TranslateAnimation(0, 0, 0, 531);
		translateAnim.setDuration(500);
		translateAnim.setInterpolator(new AccelerateInterpolator());
		translateAnim.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				map_iv_hand.setVisibility(View.INVISIBLE);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
		map_iv_hand.startAnimation(translateAnim);

		Animation translateAnim1 = new TranslateAnimation(0, 0, 0, 354);
		translateAnim1.setDuration(300);
		translateAnim1.setStartOffset(200);
		translateAnim1.setInterpolator(new AccelerateInterpolator());
		translateAnim1.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				map_iv_metro.setVisibility(View.INVISIBLE);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
		map_iv_metro.startAnimation(translateAnim1);

		Animation translateAnim2 = new TranslateAnimation(0, 0, 0, 177);
		translateAnim2.setDuration(100);
		translateAnim2.setStartOffset(400);
		translateAnim2.setInterpolator(new AccelerateInterpolator());
		translateAnim2.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				map_iv_school.setVisibility(View.INVISIBLE);
				map_icon_location.setImageResource(R.drawable.ic_close_white_24dp);
				map_icon_location.setBackgroundResource(R.drawable.ic_map_icon_bg);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
		map_iv_school.startAnimation(translateAnim2);
	}

	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}
}
