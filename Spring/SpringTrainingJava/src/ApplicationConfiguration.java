

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.iresh.training.salesmanager.repository.EmployeeRepository;
import com.iresh.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.iresh.training.salesmanager.service.EmployeeService;
import com.iresh.training.salesmanager.service.EmployeeServiceImpl;

@Configuration
public class ApplicationConfiguration {

	@Bean(name = "employeeService")
	public EmployeeService getEmployeeService() {
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		employeeService.setEmployeeRepository(getEmployeeRepository());
		return employeeService;

	}

	@Bean(name = "employeeRepository")
	public EmployeeRepository getEmployeeRepository() {
		return new HibernateEmployeeRepositoryImpl();
	}
}
