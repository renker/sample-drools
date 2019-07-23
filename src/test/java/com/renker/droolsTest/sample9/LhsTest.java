package com.renker.droolsTest.sample9;

import org.junit.Test;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

import com.renker.drools.sample9.model.Student;
import com.renker.drools.sample9.model.Teacher;

public class LhsTest {
	@Test
	public void test(){
		KieHelper kieHelper = new KieHelper();
		Resource resource = ResourceFactory.newClassPathResource("rules/sample9/lhs1.drl");
		kieHelper.addResource(resource, ResourceType.DRL);
		kieHelper.build();
		
		KieContainer kieContainer = kieHelper.getKieContainer();
		KieSession kieSession = kieContainer.newKieSession();
		Student s = new Student();
		s.setAge(10);
		Teacher t = new Teacher();
		t.setAge(10);
		kieSession.insert(s);
		kieSession.insert(t);
		int count = kieSession.fireAllRules();
		
		System.out.println("执行"+count+"条规则");
		
	}
	
	
	@Test
	public void test2(){
		KieHelper kieHelper = new KieHelper();
		Resource resource = ResourceFactory.newClassPathResource("rules/sample9/lhs2.drl");
		kieHelper.addResource(resource, ResourceType.DRL);
		
		KieContainer kieContainer = kieHelper.getKieContainer();
		KieSession kieSession = kieContainer.newKieSession();
		
		Student s = new Student();
		s.setAge(10);
		kieSession.insert(s);
		
		Teacher t = new Teacher();
		t.setAge(10);
		t.setScore(1000);
		kieSession.insert(t);
		
		int count = kieSession.fireAllRules();
		
		System.out.println("执行"+count+"条规则");
		
	}
}
