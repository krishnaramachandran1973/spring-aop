package com.wipro.aop.before.advice.security;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class SecurityDemo {
	public static void main(String[] args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(SecurityConfigurer.class);
		AuthenticationManager authManager = ctx.getBean(AuthenticationManager.class);
		SecureBean secureBean = getSecureBean(ctx);

		authManager.login("John", "pwd");
		secureBean.writeSecureMessage();
		authManager.logout();

		try {
			authManager.login("invalid user", "pwd");
			secureBean.writeSecureMessage();
		} catch (SecurityException ex) {
			System.out.println("Exception Caught: " + ex.getMessage());
		} finally {
			authManager.logout();
		}

		try {
			secureBean.writeSecureMessage();
		} catch (SecurityException ex) {
			System.out.println("Exception Caught: " + ex.getMessage());
		}

	}

	private static SecureBean getSecureBean(ApplicationContext ctx) {
		SecureBean target = ctx.getBean(SecureBean.class);
		SecurityAdvice advice = ctx.getBean(SecurityAdvice.class);

		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(target);
		factory.addAdvice(advice);
		SecureBean proxy = (SecureBean) factory.getProxy();
		return proxy;
	}

}
