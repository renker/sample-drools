package com.renker.droolsTest.sample8;

import java.io.StringWriter;

import javax.annotation.Resource;

import org.drools.compiler.lang.dsl.DSLMappingFile;
import org.drools.compiler.lang.dsl.DSLTokenizedMappingFile;
import org.drools.compiler.lang.dsl.DefaultExpander;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

import com.renker.drools.model.Student;
import com.renker.droolsTest.BaseTest;

public class DslTest extends BaseTest{

	@Test
	public void dsl(){
		KieServices kieServices = KieServices.Factory.get();
		KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
		KieSession session = kieClasspathContainer.newKieSession("ks-dsl");
		Student student = new Student();
		student.setName("张三");
		session.insert(student);
		int count = session.fireAllRules();
		
		System.out.println("执行"+count+"条规则");
		
	}
	
	@Test
	public void dslHelper(){
		try {
			KieHelper kieHelper = new KieHelper();
			org.kie.api.io.Resource dslr = ResourceFactory.newClassPathResource("rules/sample8/dsl/dsl.dslr");
			org.kie.api.io.Resource dsl = ResourceFactory.newClassPathResource("rules/sample8/dsl/dsl.dsl");
			kieHelper.addResource(dslr, ResourceType.DSLR);
			kieHelper.addResource(dsl, ResourceType.DSLR);
			
			KieSession kieSession = kieHelper.build().newKieSession();
			
			Student student = new Student();
			student.setName("张三");
			student.setAge(10);
			kieSession.insert(student);
			int count = kieSession.fireAllRules();
			
			System.out.println("执行"+count+"条规则");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void dslSampe(){
		try {
			KieHelper kieHelper = new KieHelper();
			org.kie.api.io.Resource dslr = ResourceFactory.newClassPathResource("rules/sample8/dsl/sample.dslr");
			org.kie.api.io.Resource dsl = ResourceFactory.newClassPathResource("rules/sample8/dsl/sample.dsl");
			kieHelper.addResource(dslr, ResourceType.DSLR);
			kieHelper.addResource(dsl, ResourceType.DSLR);
			
//			DefaultExpander expander = new DefaultExpander();
//			DSLTokenizedMappingFile dslMappingFile = new DSLTokenizedMappingFile();
//			dslMappingFile.parseAndLoad(dslr.getReader());
//			expander.addDSLMapping(dslMappingFile.getMapping());
			
			KieSession kieSession = kieHelper.build().newKieSession();
			
			Student student = new Student();
			student.setName("张三");
			student.setAge(10);
			kieSession.insert(student);
			int count = kieSession.fireAllRules();
			
			System.out.println("执行"+count+"条规则");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
