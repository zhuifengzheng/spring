package com.mybatis.v2.factorybean;

import com.mybatis.v2.anno.TulingSelect;
import com.mybatis.v2.entity.AccountInfo;
import com.mybatis.v2.entity.ProductInfo;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * [来个全套]
 *
 * @slogan: 高于生活，源于生活
 * @Description: TODO
 * @author: smlz
 * @date 2020/5/5 14:44
 */
public class TulingMapperFactorybean implements FactoryBean<Object> {

	private Class<Object> targetClass;

	public TulingMapperFactorybean(Class<Object> targetClass) {
		this.targetClass = targetClass;
	}

	@Nullable
	@Override
	public Object getObject() throws Exception {
		return Proxy.newProxyInstance(this.targetClass.getClassLoader(),new Class<?>[]{targetClass},new TulingMapperProxy());
//		return (T) Proxy.newProxyInstance(this.targetClass.getClassLoader(),new Class<?>[]{targetClass},new TulingMapperProxy());
	}

	@Nullable
	@Override
	public Class<?> getObjectType() {
		return targetClass;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}

class TulingMapperProxy implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//处理Object原生的方法
		if(method.getDeclaringClass().equals(Object.class)) {
			return method.invoke(this, args);
		}

		TulingSelect tulingSelect = method.getAnnotation(TulingSelect.class);
		String parseSql = tulingSelect.value();
		System.out.println("解析业务sql:"+parseSql+"入参:"+ Arrays.asList(args));

		Class<?> clazz = method.getReturnType();

		// todo
//		if (clazz!=null) {
//			return clazz.newInstance();
//		}
		if(clazz.equals(ProductInfo.class)) {
			ProductInfo productInfo = new ProductInfo();
			productInfo.setProductName("测试");
			return productInfo;
		}
		if(clazz.equals(AccountInfo.class)) {
			return new AccountInfo();
		}
		return null;
	}
}
