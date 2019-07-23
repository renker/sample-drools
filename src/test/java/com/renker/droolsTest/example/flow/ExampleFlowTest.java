package com.renker.droolsTest.example.flow;

import java.math.BigDecimal;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.definition.type.FactType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.renker.droolsTest.BaseTest;

public class ExampleFlowTest extends BaseTest{

	@Test
	public void exampleFlow() throws InstantiationException, IllegalAccessException{
		KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
		KieSession kieSession = kieContainer.newKieSession("ks-example-flow");
		
		FactType factType = kieSession.getKieBase().getFactType("rules.example.flow", "LongTermInsuranceMainFlow");
		
		
		Object main = factType.newInstance();
//		factType.set(main, "protocolNo", "00001");
//		factType.set(main, "code", "00005");
		
//		factType.set(main, "protocolNo", "00001");
//		factType.set(main, "code", "00320");
		
//		factType.set(main, "protocolNo", "00002");
//		factType.set(main, "code", "00005");
		
		factType.set(main, "protocolNo", "00002");
		factType.set(main, "code", "00320");
		
		
		factType.set(main, "paymentPeriod", 1);
		factType.set(main, "time", 1);
		factType.set(main, "money", new BigDecimal(13421));
		
		kieSession.insert(main);
		
		kieSession.startProcess("insuranceFlow");
		
		int count = kieSession.fireAllRules();
		
		System.out.println("执行 "+count+" 条规则 "
				+" 基本续保费用："+factType.get(main, "money")
				+"\t 应付基本手续费率："+factType.get(main, "baseFeeRate")
				+" 应付基本手续费用："+factType.get(main, "baseFee")
				+"\t 基本保费 率："+factType.get(main, "baseMoneyRate")
				+" 基本保费：" + factType.get(main, "baseMoney")
				);
	}
	
}
