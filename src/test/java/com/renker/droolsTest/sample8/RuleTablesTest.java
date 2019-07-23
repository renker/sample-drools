package com.renker.droolsTest.sample8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

import com.renker.droolsTest.BaseTest;

public class RuleTablesTest extends BaseTest{
	
	
	@Test
	public void excelCompile() throws FileNotFoundException{
		InputStream is = new FileInputStream("C:/Users/Chen/Desktop/RuleSet.xlsx");
		
		SpreadsheetCompiler spreadsheetCompiler = new SpreadsheetCompiler();
		
		String drl = spreadsheetCompiler.compile(is, InputType.XLS);
		
		System.out.println(drl);
	}
	
	@Test
	public void excel(){
//		Resource resource = (Resource) ResourceFactory.newClassPathResource("/reuls/sample8/RuleSet.xlsx",ExcelTest.class);
		Resource resource = (Resource) ResourceFactory.newFileResource("C:/Users/Chen/Desktop/RuleSet.xlsx");
		KieHelper kieHelpe = new KieHelper();
		kieHelpe.addResource(resource, ResourceType.DTABLE);
		KieSession kieSession = kieHelpe.build().newKieSession();
		int count = kieSession.fireAllRules();
		
		System.out.println("执行"+count+"条规则");
	}
	
	@Test
	public void tables(){
		KieServices kieServices = KieServices.Factory.get();
		KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
		KieSession session = kieClasspathContainer.newKieSession("ks-ruleTables");
		int count = session.fireAllRules();
		System.out.println("执行"+count+"条规则");
	}
}
