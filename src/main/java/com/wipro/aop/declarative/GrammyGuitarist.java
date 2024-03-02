package com.wipro.aop.declarative;

import lombok.ToString;

@ToString
public class GrammyGuitarist {

	public void sing() {
		System.out.println("sing: Gravity is working against me\n And gravity wants to bring me down");
	}

	public void sing(Guitar guitar) {
		System.out.println("play: " + guitar.play());
	}

	public void talk() {
		System.out.println("talk");
	}

}
