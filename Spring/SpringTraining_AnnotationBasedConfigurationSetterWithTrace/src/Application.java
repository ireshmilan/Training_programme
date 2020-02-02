import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iresh.training.salesmanager.model.Employee;
import com.iresh.training.salesmanager.service.EmployeeService;
import com.iresh.training.salesmanager.service.EmployeeServiceImpl;

public class Application {

	public static void main(String[] args) {
		//EmployeeService employeeService = new EmployeeServiceImpl();
		
		ApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeService employeeService=applicationContext.getBean("employeeService",EmployeeService.class);
		
		List<Employee> employees = employeeService.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.getemployeeName() + " at " + employee.getemployeeLocation());
		}

	}

}
