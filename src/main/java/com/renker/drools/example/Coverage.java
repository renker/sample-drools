package com.renker.drools.example;

import java.math.BigDecimal;

/**
 * 险种
 * @author	chenyintao
 * @date:	2019年5月15日 下午2:01:14
 */
public class Coverage {
	/**
	 * 险种代码
	 */
	private String code;
	/**
	 * 缴费期限
	 */
	private Integer paymentPeriod;
	/**
	 * 交费次数 （首年 二年 三年 四年 五年）
	 */
	private Integer time;
	/**
	 * 续期保费
	 */
	private BigDecimal money;
	
	/**
	 * 基本手续费率
	 */
	private BigDecimal baseFeeRate;
	/**
	 * 基本手续费
	 */
	private BigDecimal baseFee;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getPaymentPeriod() {
		return paymentPeriod;
	}
	public void setPaymentPeriod(Integer paymentPeriod) {
		this.paymentPeriod = paymentPeriod;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public BigDecimal getBaseFee() {
		return baseFee;
	}
	public void setBaseFee(BigDecimal baseFee) {
		this.baseFee = baseFee;
	}
	public BigDecimal getBaseFeeRate() {
		return baseFeeRate;
	}
	public void setBaseFeeRate(BigDecimal baseFeeRate) {
		this.baseFeeRate = baseFeeRate;
	}
	
}
