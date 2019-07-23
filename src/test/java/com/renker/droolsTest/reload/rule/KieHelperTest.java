package com.renker.droolsTest.reload.rule;

import javax.annotation.Resource;

import org.junit.Test;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

import com.renker.droolsTest.BaseTest;

public class KieHelperTest extends BaseTest{
	
	@Resource
	private KieModuleModel kieModuleModel;
	
	@Resource
	private KieFileSystem kieFileSystem;
	
	@Test
	public void kieHelper(){
		KieHelper kieHelper = new KieHelper();
		
		String ruleContent = "package rules.reload.reloadRule\n\n rule \"Postcode 6 numbers\"\n\n    when\n  then\n        System.out.println(\"规则2中打印日志：校验通过!\");\n end";
		
		kieHelper.addContent(ruleContent, ResourceType.DRL);
		
		kieHelper.addContent(ruleContent, ResourceType.DRL);
		
//		String xml = kieModuleModel.toXML();
//		// kieFileSystem.writeKModuleXML(xml);
//		System.out.println("drools kmodule.xml内容： \n"+xml);
		
		
		KieSession kieSession = kieHelper.getKieContainer().newKieSession();
		kieSession.fireAllRules();
	}

}
