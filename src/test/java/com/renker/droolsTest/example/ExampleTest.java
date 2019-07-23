package com.renker.droolsTest.example;

import java.math.BigDecimal;
import java.util.Scanner;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.definition.type.FactType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;

import com.renker.droolsTest.BaseTest;

public class ExampleTest extends BaseTest{
	
	@Test
	public void LongTermInsuranceMainTest() throws InstantiationException, IllegalAccessException{
		KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
		KieSession kieSession = kieContainer.newKieSession("ks-example");
		
		FactType factType = kieSession.getKieBase().getFactType("rules.example", "LongTermInsuranceMain");
		
//		System.out.println("请输入险种代码");
//		Scanner scan = new Scanner(System.in);
//		String code = scan.nextLine();
//		System.out.println("请输入交费期限");
//		Integer paymentPeriod = Integer.valueOf(scan.nextLine());
//		System.out.println("请输入第几年续费");
//		Integer time = Integer.valueOf(scan.nextLine());
//		System.out.println("请输入第续费金额");
//		Integer money = Integer.valueOf(scan.nextLine());
		
		
		Object main = factType.newInstance();
		factType.set(main, "code", "00005");
		factType.set(main, "paymentPeriod", 1);
		factType.set(main, "time", 1);
		factType.set(main, "money", new BigDecimal(13421));
		
		kieSession.insert(main);
		
		int count = kieSession.fireAllRules();
		
		
		kieSession.fireAllRules(new AgendaFilter() {
			
			@Override
			public boolean accept(Match match) {
				match.getObjects();
				return false;
			}
		});
		
		
		System.out.println("执行 "+count+" 条规则 "
			+" 基本续保费用："+factType.get(main, "money")
			+" 应付基本手续费率："+factType.get(main, "baseFeeRate")
			+" 应付基本手续费用："+factType.get(main, "baseFee"));
		
	}
	
	
	@Test
	public void LongTermInsuranceMainFlowTest() throws InstantiationException, IllegalAccessException{
		KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
		KieSession kieSession = kieContainer.newKieSession("ks-example");
		
		FactType factType = kieSession.getKieBase().getFactType("rules.example", "LongTermInsuranceMain");
		
//		System.out.println("请输入险种代码");
//		Scanner scan = new Scanner(System.in);
//		String code = scan.nextLine();
//		System.out.println("请输入交费期限");
//		Integer paymentPeriod = Integer.valueOf(scan.nextLine());
//		System.out.println("请输入第几年续费");
//		Integer time = Integer.valueOf(scan.nextLine());
//		System.out.println("请输入第续费金额");
//		Integer money = Integer.valueOf(scan.nextLine());
		
		Object main = factType.newInstance();
		factType.set(main, "code", "00005");
		factType.set(main, "paymentPeriod", 1);
		factType.set(main, "time", 1);
		factType.set(main, "money", new BigDecimal(13421));
	}
	
}
