package data;

import java.util.List;

import model.Department;

public interface DepartmentDAO {
	public int add(Department dept);
	public int delete();
	public List<Department> getAllDepartments();
	
}
