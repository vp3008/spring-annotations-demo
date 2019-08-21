package com.deepankar.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class TennisCoach implements Coach {

	// this is field injection
	@Autowired
	@Qualifier("randomFortuneService")
	FortuneService FortuneService;
	public TennisCoach()
	{
		System.out.println("Inside default constructor: Tennis Coach");
	}
	
	
	/*
	 * //this is constructor injection using annotations
	 * 
	 * @Autowired public TennisCoach(FortuneService theFortuneService) { super();
	 * this.FortuneService = theFortuneService; }
	 */
	
	
	/*
	 * //this is setter injection using annotations
	 * 
	 * @Autowired public void setFortuneService(FortuneService theFortuneService) {
	 * System.out.println("Tennis coach : inside setFortuneService method");
	 * this.FortuneService = theFortuneService; }
	 */
	 
	
	/*
	 * //Method injection::this still works, so setter methods is not necessary, any
	 * method will do
	 * 
	 * @Autowired public void someRandomMethodName(FortuneService theFortuneService)
	 * { System.out.println("Tennis coach : inside someRandomMethodName method");
	 * this.FortuneService = theFortuneService; }
	 */

	//init method
	@PostConstruct
	public void doStartUpStuff()
	{
		System.out.println("TennisCoach : Inside of doStartUpStuff()");
	}
	
	//destroy method
	@PreDestroy
	public void doCleanUpStuff()
	{
		System.out.println("TennisCoach : Inside of doCleanUpStuff()");
	}
	

	@Override
	public String getDailyWorkout() {
		
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return FortuneService.getFortune();
	}

}
