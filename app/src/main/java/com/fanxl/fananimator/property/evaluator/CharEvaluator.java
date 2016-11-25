package com.fanxl.fananimator.property.evaluator;

import android.animation.TypeEvaluator;

/**
 * Created by fanxl2 on 2016/11/25.
 */

public class CharEvaluator implements TypeEvaluator<Character> {

	@Override
	public Character evaluate(float fraction, Character startValue, Character endValue) {

		int startInt  = (int)startValue;
		int endInt = (int)endValue;
		int curInt = (int)(startInt + fraction *(endInt - startInt));
		char result = (char)curInt;
		return result;
	}
}
