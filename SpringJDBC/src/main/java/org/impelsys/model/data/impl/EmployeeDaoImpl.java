package org.impelsys.model.data.impl;

import org.impelsys.model.Employee;
import org.impelsys.model.EmployeeMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDaoImpl {
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	JdbcTemplate jdbcTemplate;
	
	
	public int saveEmp(Employee e){
		String sql="insert into Employee(empName,age) values(:name,:age)";
		//SqlParameterSource
		return 1;
	}

	
	public Employee getEmployee(int id){
		String sql="select * from Employee where empId=?";
		Employee result=(Employee) jdbcTemplate.queryForObject(sql,new Object[]{id},new EmployeeMapper());
				return result;
	}
	
}
