package com.wipro.aop.declarative;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Documentarist {

	private GrammyGuitarist guitarist;

	public void execute() {
		guitarist.sing();
		guitarist.talk();
	}
}
