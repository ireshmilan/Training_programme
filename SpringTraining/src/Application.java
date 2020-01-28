import java.util.List;

import com.iresh.training.salesmanager.model.Employee;
import com.iresh.training.salesmanager.service.EmployeeService;
import com.iresh.training.salesmanager.service.EmployeeServiceImpl;

public class Application {

	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeServiceImpl();
		List<Employee> employees = employeeService.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.getemployeeName() + " at " + employee.getemployeeLocation());
		}

	}

}
