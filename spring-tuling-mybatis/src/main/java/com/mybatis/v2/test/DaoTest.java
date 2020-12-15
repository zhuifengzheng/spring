package com.mybatis.v2.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author by yuanpeng
 * @Date 2020/12/14
 */
//@Component
public class DaoTest {
	@Autowired
	private ControllerTest controllerTest;
	@Autowired
	private ServiceTest serviceTest;
}
