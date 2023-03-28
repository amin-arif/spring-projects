package com.dev;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanTest  implements InitializingBean, DisposableBean {
	
	public void show() {
		System.out.println("This a method from BeanTest class");
	}
	
	public void start() {
		System.out.println("=============== Before bean initialization ===============");
	}
	
	public void finish() {
		System.out.println("=============== Before bean destroy ===============");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("------------- Before bean initialization (2) -------------");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("------------- Before bean destroy (2) -------------");
	}

}
