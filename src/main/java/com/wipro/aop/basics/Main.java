package com.wipro.aop.basics;

import org.springframework.aop.framework.ProxyFactory;

public class Main {
	public static void main(String[] args) {
		Agent target = new Agent();

		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new AgentAdvice());
		pf.setTarget(target);

		Agent proxy = (Agent) pf.getProxy();
		
		target.speak();
		System.out.println("");
		proxy.speak();
	}
}
