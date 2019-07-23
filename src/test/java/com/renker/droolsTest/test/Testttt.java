package com.renker.droolsTest.test;

import org.junit.Test;
import org.kie.api.definition.type.FactType;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

public class Testttt {
	@Test
	public void testtt() throws InstantiationException, IllegalAccessException{
		KieHelper kieHelper = new KieHelper();
		Resource resource = ResourceFactory.newClassPathResource("rules/test/Customer.drl");
		kieHelper.addResource(resource, ResourceType.DRL);
		kieHelper.build();
		
		KieContainer kieContainer = kieHelper.getKieContainer();
		KieSession session = kieContainer.newKieSession();
		
		FactType factType = kieContainer.getKieBase().getFactType("com.fairyland.rules.ruleae5a3c9cc9524c55ad3cac6262d4b0e0", "Customer1");
		Object bean = factType.newInstance();
		final String name  = new String("zhangsan");
		factType.set(bean, "name", name);
		factType.set(bean, "age", 12);
		session.insert(bean);
		int count =  session.fireAllRules(); 
		System.out.println("-----------------------------------执行规则："+count);
	}
}
