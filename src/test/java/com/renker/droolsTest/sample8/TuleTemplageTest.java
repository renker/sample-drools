package com.renker.droolsTest.sample8;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.renker.drools.model.Student;
import com.renker.droolsTest.BaseTest;

public class TuleTemplageTest extends BaseTest{
	
	@Test
	public void templateTest(){
		try {
			KieServices kieServices = KieServices.Factory.get();
			KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
			
			KieSession session = kieClasspathContainer.newKieSession("ks-template");
			
			Student stu = new Student();
			stu.setAge(19);
			session.insert(stu);
			session.setGlobal("list", new ArrayList<String>());
			int count = session.fireAllRules();
			List<String> list = (List<String>) session.getGlobal("list");
			
			System.out.println("执行"+count+"条规则");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
