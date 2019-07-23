package com.renker.droolsTest.reload.rule;

import java.io.File;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message.Level;
import org.kie.api.builder.model.KieBaseModel;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.renker.droolsTest.BaseTest;

/**
 * 执加载规则
 * @author	chenyintao
 * @date:	2019年5月17日 下午2:29:51
 */
public class ReloadRuleTest extends BaseTest{
	@Resource
	private KieModuleModel kieModuleModel;
	@Resource
	private KieServices kieServices;
	@Resource
	private KieFileSystem kieFileSystem;
	
	/** 加载规则资源包路径 */
	public final static String BUILD_PATH = "src.main.resources";
	/** ksession 前缀 */
	public final static String SESSION = "ksession_";
	
	@Test
	public void reloadRule(){
		kieServices.getKieClasspathContainer();
		String packageContent = "rules.reload.reloadRule";
		String ruleName = "test_reload_rule";
		Map<String, KieBaseModel> map = kieModuleModel.getKieBaseModels();
		if(map != null && map.keySet().contains(ruleName)){
			kieModuleModel.removeKieBaseModel(ruleName);
		}
		
		KieBaseModel kieBaseModel = kieModuleModel.newKieBaseModel(ruleName);
		kieBaseModel.addPackage("rules.reload.reloadRule");
		String kSessionName = SESSION+ruleName;
		kieBaseModel.newKieSessionModel(kSessionName);
		
		String buildPath = (BUILD_PATH+"."+packageContent).replace(".", File.separator)+File.separator+ruleName+".drl";
		String ruleContent = "package rules.reload.reloadRule\n\n rule \"Postcode 6 numbers\"\n\n    when\n  then\n        System.out.println(\"规则2中打印日志：校验通过!\");\n end";
		kieFileSystem.write(buildPath, ruleContent);
		
		
		String xml = kieModuleModel.toXML();
		kieFileSystem.writeKModuleXML(xml);
		System.out.println("drools kmodule.xml内容： \n"+xml);
		
		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
		kieBuilder.buildAll();
		if(kieBuilder.getResults().hasMessages(Level.ERROR)){
			System.out.println("装载规则出错："+kieBuilder.getResults().toString());
		} 
		
		
//		KieBaseModel dbKieBaseModel = kieModuleModel.getKieBaseModels().get(ruleName);
//		dbKieBaseModel
		
		KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
		KieSession kieSession = kieContainer.newKieSession(kSessionName);
		int count = kieSession.fireAllRules();
		System.out.println("执行 "+count+" 个规则");
		
	}
	
//	@Test
//	public void kieHelper(){
//		KieHelper kieHelper = new KieHelper();
//		kieHelper.
//	}
	

}
