package com.wipro.aop.before.advice.security;

import org.springframework.stereotype.Component;

@Component
public class SecureBean {
	// @Transaction
	public void writeSecureMessage() {
		System.out.println("Every time I learn something new, it pushes some old stuff out of my brain");
	}
}
