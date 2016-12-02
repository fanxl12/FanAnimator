package com.fanxl.fananimator.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.fanxl.fananimator.R;

/**
 * Created by fanxl2 on 2016/12/2.
 */

public class AnimationActivity extends AppCompatActivity {

	private ImageView iv_test_img;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_animation);

		iv_test_img = (ImageView) findViewById(R.id.iv_test_img);

		findViewById(R.id.bt_scale_up).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				int phoneWidth = getPhoneWidth(AnimationActivity.this);

				ActivityOptionsCompat compat = ActivityOptionsCompat.
						makeScaleUpAnimation(iv_test_img, iv_test_img.getWidth()/2, iv_test_img.getHeight()/2,
								phoneWidth, dip2px(AnimationActivity.this, 100));

				ActivityCompat.startActivity(AnimationActivity.this,
						new Intent(AnimationActivity.this, TestActivity.class), compat.toBundle());
			}
		});

		findViewById(R.id.bt_scale_thumb).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				ActivityOptionsCompat compat = ActivityOptionsCompat.
						makeThumbnailScaleUpAnimation(iv_test_img, iv_test_img.getDrawingCache(),
								iv_test_img.getWidth()/2, iv_test_img.getHeight()/2);

				ActivityCompat.startActivity(AnimationActivity.this,
						new Intent(AnimationActivity.this, TestActivity.class), compat.toBundle());
			}
		});

		findViewById(R.id.bt_scene_tran).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				ActivityOptionsCompat compat = ActivityOptionsCompat.
						makeSceneTransitionAnimation(AnimationActivity.this, iv_test_img, getString(R.string.imageStr));

				ActivityCompat.startActivity(AnimationActivity.this,
						new Intent(AnimationActivity.this, TestActivity.class), compat.toBundle());
			}
		});

	}

	public static int getPhoneWidth(Activity activity) {
		DisplayMetrics metric = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
		return metric.widthPixels;
	}

	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}
}
