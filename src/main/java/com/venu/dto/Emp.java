package com.venu.dto;

public class Emp {
	
	int empid;
	String ename;
	float sal;
	/**
	 * @param empid
	 * @param ename
	 * @param sal
	 */
	public Emp() {
	}
	
	public Emp(int empid, String ename, float sal) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.sal = sal;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}
	

}
