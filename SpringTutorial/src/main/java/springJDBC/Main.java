package springJDBC;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {
    public static void main(String[] args) {
    	try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            EmployeeDAO employeeDAO = context.getBean(EmployeeDAO.class);

            // Create an employee
            Employee employee = new Employee();
            employee.setId(1L);
            employee.setName("John Doe");
            employee.setAge(30);
            employeeDAO.createEmployee(employee);

            // Retrieve all employees
            List<Employee> employees = employeeDAO.getAllEmployees();
            for (Employee emp : employees) {
                System.out.println(emp.getId() + ", " + emp.getName() + ", " + emp.getAge());
            }
        }
    }
}