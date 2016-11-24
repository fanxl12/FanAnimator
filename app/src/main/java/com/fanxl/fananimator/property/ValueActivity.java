package com.fanxl.fananimator.property;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.fanxl.fananimator.R;

/**
 * Created by fanxl2 on 2016/11/24.
 */

public class ValueActivity extends AppCompatActivity {

	private static final String TAG = "ValueActivity";

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_value);

		findViewById(R.id.value_bt_start).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ValueAnimator valueAnimator = new ValueAnimator().ofInt(0, 100);
				valueAnimator.setDuration(2000);
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
	}
}
