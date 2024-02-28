package com.wipro.aop.pointcut.advisor;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointcutDemo {
	public static void main(String[] args) {
		Singer johnMayer = new GoodGuitarist();
		Singer ericClapton = new GreatGuitarist();

		Singer proxyOne;
		Singer proxyTwo;

		Pointcut pc = new SimpleStaticPointcut();
		Advice advice = new SimpleAdvice();
		// aspect is called advisor sing aop
		Advisor advisor = new DefaultPointcutAdvisor(pc, advice);

		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(johnMayer);
		proxyOne = (Singer) pf.getProxy();

		pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(ericClapton);
		proxyTwo = (Singer) pf.getProxy();

		proxyOne.sing();
		proxyTwo.sing();

	}

}
