package com.deepankar.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) 
	{
		//load spring config file
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\nPointing to the same object : " + result);
		
		System.out.println("\nMemory location for theCoach :" + theCoach);
		
		System.out.println("\nMemory location for the alphaCoach :"+ alphaCoach);

		context.close();
	}

}
