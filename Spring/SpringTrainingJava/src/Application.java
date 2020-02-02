import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iresh.training.salesmanager.model.Employee;
import com.iresh.training.salesmanager.service.EmployeeService;
import com.iresh.training.salesmanager.service.EmployeeServiceImpl;

public class Application {

	public static void main(String[] args) {
	
		ApplicationContext applicationContext= new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		
		EmployeeService employeeService=applicationContext.getBean("employeeService",EmployeeService.class);
		
		List<Employee> employees = employeeService.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.getemployeeName() + " at " + employee.getemployeeLocation());
		}

	}

}
