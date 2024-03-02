package com.wipro.aop.declarative;

import org.springframework.aop.Advisor;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.wipro.aop.declarative")
public class DeclarativeConfigurer {

	@Bean
	public GrammyGuitarist guitarist() {
		return new GrammyGuitarist();
	}

	@Bean
	public MethodBeforeAdvice advice() {
		return new AuditAdvice();
	}

	@Bean
	public Pointcut pointcut() {
		return new DeclarativeStaticPointcut();
	}

	@Bean
	public Advisor pointcutAdvisor() {
		return new DefaultPointcutAdvisor(pointcut(), advice());

	}

	@Bean
	public ProxyFactoryBean factoryBean() {
		ProxyFactoryBean factoryBean = new ProxyFactoryBean();
		factoryBean.setTarget(guitarist());
		factoryBean.setProxyTargetClass(true);
		factoryBean.addAdvisor(pointcutAdvisor());
		return factoryBean;
	}

	@Bean
	public Documentarist documentarist() {
		Documentarist documentarist = new Documentarist();
		documentarist.setGuitarist((GrammyGuitarist) factoryBean().getObject());
		return documentarist;
	}

}
