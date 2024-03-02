package com.wipro.aop.declarative;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
		ctx.refresh();

		Documentarist documentarist = ctx.getBean("documentarist", Documentarist.class);
		documentarist.execute();

		System.out.println("----------------------");

		Documentarist documentarist2 = ctx.getBean("documentaristTwo", Documentarist.class);
		System.out.println(documentarist2.getGuitarist().getClass());
		documentarist2.execute();

		System.out.println("-------------------------");

		AnnotationConfigApplicationContext annCtx = new AnnotationConfigApplicationContext(DeclarativeConfigurer.class);
		Documentarist documentarist3 = annCtx.getBean(Documentarist.class);
		System.out.println(documentarist3.getGuitarist().getClass());
		documentarist3.execute();
		//Proxy8.

	}

}
