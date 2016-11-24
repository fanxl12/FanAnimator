package com.fanxl.fananimator.entity;

/**
 * Created by fanxl2 on 2016/11/24.
 */

public class MainBean {

	private Class mClass;

	private String name;

	public MainBean(Class mClass) {
		this.mClass = mClass;
		this.name = mClass.getSimpleName();
	}

	public Class getmClass() {
		return mClass;
	}

	public String getName() {
		return name;
	}
}
