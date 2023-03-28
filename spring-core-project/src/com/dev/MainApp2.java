package com.dev;

import java.util.HashSet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp2 {

	public static void main(String args[]) {
		
		// For bean life cycle
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/dev/ApplicationContext.xml");
		context.registerShutdownHook(); // It uses for destroy bean (forcefully) when bean have no task
		
		BeanTest beanTest = (BeanTest) context.getBean("beanTest");
		BeanTest beanTest2 = (BeanTest) context.getBean("beanTest");
		HashSet<BeanTest> beans = new HashSet<>();
		beans.add(beanTest);
		beans.add(beanTest2);
		
		beanTest.show();
		System.out.println(
				/*
				 * When bean scope is singleton the hash code of class objects is same
				 * When bean scope is prototype the hash code of class objects is different
				 */
				"\nhashCode of beanTest: " + beanTest.hashCode() + "\n" +
				"hashCode of beanTest2: " + beanTest2.hashCode() + "\n" +
				"bean size: " + beans.size() + "\n" + // (Size 1 => When Singleton scope; Size 2 => When Prototype scope;)
						
				"is Active: " + context.isActive() + "\n" +
				"is Running: " + context.isRunning() + "\n" +
				"is Singleton: " + context.isSingleton("beanTest") + "\n" +
				"is Prototype: " + context.isPrototype("beanTest") + "\n"
			);

	}
}
