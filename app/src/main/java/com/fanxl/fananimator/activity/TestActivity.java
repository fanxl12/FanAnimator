package com.fanxl.fananimator.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.fanxl.fananimator.R;

/**
 * Created by fanxl2 on 2016/12/2.
 */

public class TestActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_test);
	}


	@Override
	public void onBackPressed() {
		super.onBackPressed();
		ActivityCompat.finishAfterTransition(this);
	}
}
