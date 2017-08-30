package com.muke.employee.dao;

import com.muke.employee.domain.Employee;

public interface EmployeeDao {

	Employee findUsernameAndPassword(Employee employee);

}
