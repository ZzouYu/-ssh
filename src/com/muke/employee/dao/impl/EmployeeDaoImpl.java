package com.muke.employee.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



import com.muke.employee.dao.EmployeeDao;
import com.muke.employee.domain.Employee;
/**
 * 员工管理实现类
 */
public class EmployeeDaoImpl extends HibernateDaoSupport  implements EmployeeDao {

	@Override
	public Employee findUsernameAndPassword(Employee employee) {
		// TODO Auto-generated method stub
		String hql="from Employee where username=? and password=?";
		List<Employee> list=this.getHibernateTemplate().find(hql, employee.getUsername(),employee.getPassword());
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
