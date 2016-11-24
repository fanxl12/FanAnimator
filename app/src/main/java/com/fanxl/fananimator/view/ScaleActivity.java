package com.fanxl.fananimator.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import com.fanxl.fananimator.R;

/**
 * Created by fanxl2 on 2016/11/23.
 */

public class ScaleActivity extends AppCompatActivity {

	private Animation scaleAnim;
	private TextView anim_tv;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_scale);

		anim_tv = (TextView) findViewById(R.id.anim_tv);

		findViewById(R.id.xml_bt_start).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				scaleAnim = AnimationUtils.loadAnimation(ScaleActivity.this, R.anim.scale_anim);
				anim_tv.startAnimation(scaleAnim);
			}
		});

		findViewById(R.id.xml_bt_set).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				scaleAnim = AnimationUtils.loadAnimation(ScaleActivity.this, R.anim.view_set_anim);
				scaleAnim.setRepeatCount(4);
				anim_tv.startAnimation(scaleAnim);
			}
		});

		findViewById(R.id.code_bt_start).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				scaleAnim = new ScaleAnimation(0.5f, 2.0f, 0.5f, 2.0f);
				scaleAnim.setDuration(2000);
				scaleAnim.setRepeatCount(3);
				scaleAnim.setRepeatMode(Animation.REVERSE);
				scaleAnim.setStartOffset(500);
				anim_tv.startAnimation(scaleAnim);
			}
		});
	}
}
