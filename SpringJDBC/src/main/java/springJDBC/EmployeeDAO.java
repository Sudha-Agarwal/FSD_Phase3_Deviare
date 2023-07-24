package springJDBC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public EmployeeDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void createEmployee(Employee employee) {
		String sql = "INSERT INTO Employee (id, name, age) VALUES(?,?,?)";
		jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getAge());
		
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees(){
		String sql = "SELECT * FROM employees";
		return (List<Employee>) jdbcTemplate.query(sql, (rs, rowNum) -> {
			Employee emp = new Employee();
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setAge(rs.getInt("age"));
			return emp;			
		});
	}

}
