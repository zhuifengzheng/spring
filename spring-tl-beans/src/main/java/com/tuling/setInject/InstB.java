package com.tuling.setInject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by smlz on 2019/8/22.
 */
@Component
public class InstB {

	@Autowired
	private InstA instA;
}
