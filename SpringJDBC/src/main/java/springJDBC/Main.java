package springJDBC;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)){
			
			EmployeeDAO employeeDAO = context.getBean(EmployeeDAO.class);
			
			Employee employee = context.getBean(Employee.class);
			
			employee.setId(2);
			employee.setName("ABC");
			employee.setAge(20);
			
			employeeDAO.createEmployee(employee);
			
			//Retrieve all employees
			
			
		}

	}

}
