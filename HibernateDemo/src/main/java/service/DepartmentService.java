package service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.DepartmentDAO;
import model.Department;

@Service
public class DepartmentService {
	
		@Autowired
		DepartmentDAO departmentDAOImpl;
		
		@PostConstruct
		public void setup(){
			
		}

	public int addDepartment(Department dept) {
		// TODO Auto-generated method stub
		int deptId;
		System.out.println("Adding department");
		deptId=departmentDAOImpl.add(dept);
		return deptId;
	}
	
	public List<Department> getAllDepartments(){
		List<Department> deptList=departmentDAOImpl.getAllDepartments();
		return null;
	}

}
