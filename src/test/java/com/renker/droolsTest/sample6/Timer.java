package com.renker.droolsTest.sample6;

import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.definition.type.FactType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.renker.droolsTest.BaseTest;

public class Timer extends BaseTest{
	
	@Test
	public void timer() throws InstantiationException, IllegalAccessException, InterruptedException{
		KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
		KieSession kieSession = kieContainer.newKieSession("ks-factObj");
		KieBase kieBase = kieSession.getKieBase();
		
		FactType factType = kieBase.getFactType("rules.sample6", "TimerCondition");
		Object fact = factType.newInstance();
		factType.set(fact, "age", 16);
		
		kieSession.insert(fact);
		kieSession.fireUntilHalt();
		
		Thread.sleep(30000);
	}

}
