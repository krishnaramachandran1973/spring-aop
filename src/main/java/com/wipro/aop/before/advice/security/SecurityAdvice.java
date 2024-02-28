package com.wipro.aop.before.advice.security;

import java.lang.reflect.Method;
import java.util.Optional;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecurityAdvice implements MethodBeforeAdvice {

	private AuthenticationManager manager;

	@Autowired
	public SecurityAdvice(AuthenticationManager manager) {
		this.manager = manager;
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		Optional<UserDetail> optionalUser = this.manager.getLoggedOnUser();
		UserDetail userDetail = optionalUser.orElseThrow(() -> new SecurityException("User does't exist"));

		if (userDetail.getUserName()
				.equals("John")) {
			System.out.println("Logged in user is John - OKAY!");
		} else {
			System.out.println("Logged in user is " + userDetail.getUserName() + " NOT GOOD :(");
			throw new SecurityException(
					"User " + userDetail.getUserName() + " is not allowed access to method " + method.getName());

		}
	}

}
