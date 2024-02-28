package com.wipro.aop.before.advice.security;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationManager {
	private static ThreadLocal<UserDetail> threadLocal = new ThreadLocal<>();

	public void login(String userName, String password) {
		threadLocal.set(new UserDetail(userName, password));
	}

	public void logout() {
		threadLocal.set(null);
	}

	public Optional<UserDetail> getLoggedOnUser() {
		return Optional.ofNullable(threadLocal.get());
	}
}
