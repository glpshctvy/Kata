package employeereport;

import java.util.Comparator;
import java.util.List;

public class EmployeeReport {

  private final List<Employee> employees;

  public EmployeeReport(List<Employee> employees) {
    this.employees = employees;
  }

  public List<Employee> createListOfEmployeesAbleToWorkOnSundays() {
    return employees.stream()
        .filter(employee -> employee.age() >= 18)
        .sorted(Comparator.comparing(Employee::name).reversed())
        .map(employee -> new Employee(employee.name().toUpperCase(), employee.age()))
        .toList();
  }
}
