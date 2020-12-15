package com.mybatis.v2.test.function;

import java.util.Random;

/**
 * @Author by yuanpeng
 * @Date 2020/12/15
 */
public class TestImpl {

	public Integer returnNumber(){
		return new Random().nextInt(10);
	}
}
