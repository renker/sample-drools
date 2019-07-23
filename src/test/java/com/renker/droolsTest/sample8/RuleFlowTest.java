package com.renker.droolsTest.sample8;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.renker.droolsTest.BaseTest;

public class RuleFlowTest extends BaseTest{
	
	@Test
	public void ruleFlow(){
		try {
			
			// ExtensibleXmlParser
			
			KieServices kieServices = KieServices.Factory.get();
			KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
			
			KieSession session = kieClasspathContainer.newKieSession("ks-ruleFlow");
			session.startProcess("ruleFlowProcess");
			int count = session.fireAllRules();
			
			System.out.println("111111");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
