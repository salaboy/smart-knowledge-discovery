package com.plugtree.smartprocessdiscovery.services;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InterviewServiceTest {
	
	private InterviewService interviewService;
	
	@Before
	public void loadContext() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:persistence-context.xml");
		interviewService = (InterviewService) applicationContext.getBean("interviewService");
	}
	
	@Test
	public void testFindAll() throws ServiceException {
		Assert.assertEquals(0, interviewService.findAll().size());
		interviewService.create("A description", 1l, 1l);
		Assert.assertEquals(1, interviewService.findAll().size());
	}

}
