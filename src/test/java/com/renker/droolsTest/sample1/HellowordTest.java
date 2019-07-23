package com.renker.droolsTest.sample1;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.definition.type.FactType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.renker.drools.model.Person;
import com.renker.droolsTest.BaseTest;

public class HellowordTest extends BaseTest{
	
	@Test
	public void hellowrd(){
		
		KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
		KieSession kieSession = kieContainer.newKieSession("ksession-helloword");
		
		Person person = new Person();
		person.setAge(21);
		
		kieSession.insert(person);
		int count = kieSession.fireAllRules();
		System.out.println("执行"+count+"条规则");
		
	}
}
