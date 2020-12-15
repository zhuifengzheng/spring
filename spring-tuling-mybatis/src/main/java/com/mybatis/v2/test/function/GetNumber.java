package com.mybatis.v2.test.function;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author by yuanpeng
 * @Date 2020/12/15
 */
public class GetNumber {
	Map<String, Test> map = new HashMap<>();

	/**
	 * 函数式编程：方法参数是一个函数，我们只需要关注这个函数到入参和出参即可
	 * 我们可以在方法中调用函数的方法test，得到函数返回值后再执行test方法之后的逻辑
	 * @param args
	 */
	public static void main(String[] args) {
		new GetNumber().test(() -> {
			Integer integer = new TestImpl().returnNumber();
			System.out.println("number: " + integer);
			return integer;
		});
		// 先打印number后打印get
//		new GetNumber().test(() -> getResultNumber());
	}

	public void test(Test test) {
		map.put("test", test);
		System.out.println("get: " + test.getNumber());
		// todo 其他逻辑
	}

	public static Integer  getResultNumber(){
		return new Random().nextInt();
	}
}
