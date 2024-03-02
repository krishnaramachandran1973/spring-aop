package com.wipro.aop.declarative;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class DeclarativeStaticPointcut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return ("sing".equals(method.getName()));

	}

	@Override
	public ClassFilter getClassFilter() {
		return cls -> cls == GrammyGuitarist.class;

	}

}
