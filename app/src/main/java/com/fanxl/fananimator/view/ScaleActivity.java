package com.fanxl.fananimator.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.fanxl.fananimator.R;

/**
 * Created by fanxl2 on 2016/11/23.
 */

public class ScaleActivity extends AppCompatActivity {

	private Animation scaleAnim;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_scale);

		findViewById(R.id.xml_bt_start).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				scaleAnim = AnimationUtils.loadAnimation(ScaleActivity.this, R.anim.scale_anim);
				scaleAnim.start();
			}
		});
	}
}
