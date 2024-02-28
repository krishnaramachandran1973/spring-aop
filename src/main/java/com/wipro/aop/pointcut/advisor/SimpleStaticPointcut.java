package com.wipro.aop.pointcut.advisor;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return ("sing".equals(method.getName()));

	}

	@Override
	public ClassFilter getClassFilter() {
		return cls -> cls == GoodGuitarist.class;

	}

}
