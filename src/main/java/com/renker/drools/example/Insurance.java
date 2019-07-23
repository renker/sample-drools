package com.renker.drools.example;

import java.util.List;

/**
 * 保险
 * @author	chenyintao
 * @date:	2019年5月15日 下午2:01:25
 */
public class Insurance {
	/**
	 * 长期险-主险
	 */
	private List<LongTermInsuranceMain> LongInsurances;
	/**
	 * 长期险-附加险
	 */
	private List<LongTermInsuranceOther> longOtherInsurances;
	/**
	 * 短期险
	 */
	private List<ShortTermInsurance> shortTermInsurances;
}
