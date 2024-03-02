package com.wipro.aop.basics;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
// Around advice
public class AgentAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.print("James ");
		Object retVal = invocation.proceed();
		System.out.println("!");
		return retVal;
	}
}
