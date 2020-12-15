package com.mybatis.v2.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author by yuanpeng
 * @Date 2020/12/14
 */
@Controller
public class ControllerTest{
	@Autowired
	private ServiceTest serviceTest;

//	@Autowired
//	private DaoTest daoTest;

	public void test(Integer a){
		System.out.println("================controller==========");
	}
}

