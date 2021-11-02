package net.javaguides.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

import java.util.List;

@Component
public class DataBaseLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public DataBaseLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        employeeRepository.deleteAll();
        Employee emp1 = new Employee("Sandra", "Lopez", "sandra.lopez@gmail.com");
        Employee emp2 = new Employee("Elon", "Musk", "elon.musk@gmail.com");
        Employee emp3 = new Employee("Jeff", "Bezos", "jeff.bz@gmail.com");
        Employee emp4 = new Employee("Jordan", "Hyde", "jordan.hyde@gmail.com");
        employeeRepository.saveAll(List.of(emp1, emp2, emp3, emp4));

    }

}
