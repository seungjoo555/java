package kr.kh.community.model.vo;

public class ManagerVO {

	private int manager_number; 
	private String manager_name; 
	private String manager_hire_date;
	
	public int getManager_number() {
		return manager_number;
	}
	public void setManager_number(int manager_number) {
		this.manager_number = manager_number;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getManager_hire_date() {
		return manager_hire_date;
	}
	public void setManager_hire_date(String manager_hire_date) {
		this.manager_hire_date = manager_hire_date;
	}
	
	public ManagerVO() {}
}
