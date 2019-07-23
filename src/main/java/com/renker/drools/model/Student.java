package com.renker.drools.model;

public class Student extends Person {
	/**
	 * 成绩
	 */
	private Integer score;
	
	private String className;

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
}
