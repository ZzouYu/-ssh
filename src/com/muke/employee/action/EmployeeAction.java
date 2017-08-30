package com.muke.employee.action;

import com.muke.employee.domain.Employee;
import com.muke.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	//ģ������Ҫʹ�õĶ���
	private Employee employee=new Employee();
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	//ע��SERVICE��
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String login(){
		System.out.println("action����ִ����");
		Employee existEmployee =employeeService.login(employee);
		if(existEmployee==null){
			this.addActionError("�û������������");
			return INPUT;
		}else{
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
    	
    }
}
