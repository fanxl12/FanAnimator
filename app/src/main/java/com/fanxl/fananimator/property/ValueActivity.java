package com.fanxl.fananimator.property;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;

import com.fanxl.fananimator.R;
import com.fanxl.fananimator.property.evaluator.CharEvaluator;

/**
 * Created by fanxl2 on 2016/11/24.
 */

public class ValueActivity extends AppCompatActivity {

	private static final String TAG = "ValueActivity";

	private TextView value_tv;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_value);

		findViewById(R.id.value_bt_start).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ValueAnimator valueAnimator = new ValueAnimator().ofInt(0, 100);
				valueAnimator.setDuration(2000);
				valueAnimator.setInterpolator(new AccelerateInterpolator());
				valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
					@Override
					public void onAnimationUpdate(ValueAnimator valueAnimator) {
						Log.i(TAG, "onAnimationUpdate: "+valueAnimator.getAnimatedValue());
						Log.i(TAG, "fraction: "+valueAnimator.getAnimatedFraction());
					}
				});
				valueAnimator.start();
			}
		});

		value_tv = (TextView) findViewById(R.id.value_tv);

		findViewById(R.id.value_bt_evaluator).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ValueAnimator valueAnimator = new ValueAnimator().ofObject(new CharEvaluator(), new Character('A'), new Character('Z'));
				valueAnimator.setDuration(3000);
				valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
					@Override
					public void onAnimationUpdate(ValueAnimator animation) {
						Character charValue = (Character) animation.getAnimatedValue();
						value_tv.setText(String.valueOf(charValue));
					}
				});
				valueAnimator.setInterpolator(new AccelerateInterpolator());
				valueAnimator.start();
			}
		});
	}
}
