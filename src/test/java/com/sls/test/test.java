package com.sls.test;
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sls.dao.AnswerDao;

@ContextConfiguration("classpath:spring/spring.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class test {
	@Autowired
	private AnswerDao answerDao;
	
	@Test
	public void test() throws Exception {
		int correct = answerDao.getScore(21);
		System.out.println(correct);
	}
}
