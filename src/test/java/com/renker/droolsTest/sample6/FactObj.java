package com.renker.droolsTest.sample6;

import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.definition.type.FactType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.renker.droolsTest.BaseTest;

public class FactObj extends BaseTest{
	
	/**
	 * drools 元数据用法
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@Test
	public void factObj() throws InstantiationException, IllegalAccessException{
		KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
		KieSession kieSession = kieContainer.newKieSession("ks-factObj");
		KieBase kieBase = kieSession.getKieBase();
		
		FactType factType = kieBase.getFactType("rules.sample6", "Person");
		Object fact = factType.newInstance();
		factType.set(fact, "age", 19);
		
		kieSession.insert(fact);
		int count = kieSession.fireAllRules();
		
		System.out.println("执行"+count+"条规则");
	}
	
	@Test
	public void factObjExtends() throws InstantiationException, IllegalAccessException{
		KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
		KieSession kieSession = kieContainer.newKieSession("ks-factObj");
		KieBase kieBase = kieSession.getKieBase();
		
		FactType factType = kieBase.getFactType("rules.sample6", "Student");
		Object fact = factType.newInstance();
		factType.set(fact, "age", 17);
		
		kieSession.insert(fact);
		int count = kieSession.fireAllRules();
		
		System.out.println("执行"+count+"条规则");
	}
}
