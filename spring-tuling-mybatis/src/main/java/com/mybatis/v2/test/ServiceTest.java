package com.mybatis.v2.test;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author by yuanpeng
 * @Date 2020/12/14
 */
@org.springframework.stereotype.Service
public class ServiceTest {
	@Autowired
	private ControllerTest controllerTest;

//	@Autowired
//	private DaoTest daoTest;
public void test(Integer a){
	System.out.println("================ServiceTest==========");
}

}
