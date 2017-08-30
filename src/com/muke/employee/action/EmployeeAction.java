package com.muke.employee.action;

import com.muke.employee.domain.Employee;
import com.muke.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	//模型驱动要使用的对象
	private Employee employee=new Employee();
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	//注入SERVICE类
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String login(){
		System.out.println("action方法执行了");
		Employee existEmployee =employeeService.login(employee);
		if(existEmployee==null){
			this.addActionError("用户名或密码错误");
			return INPUT;
		}else{
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
    	
    }
}
