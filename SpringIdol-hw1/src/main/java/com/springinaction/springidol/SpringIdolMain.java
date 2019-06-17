package com.springinaction.springidol;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIdolMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol.xml");

		TalentCompetition competition = ctx.getBean("springIdol", TalentCompetition.class);

		competition.run();
		ctx.close();
	}
}
