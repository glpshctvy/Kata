package employeereport;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

public class EmployeeReportTest {

  private static final List<Employee> DATA_SOURCE_OF_EMPLOYEES = List.of(
      new Employee("Max", 17),
      new Employee("Sepp", 18),
      new Employee("Nina", 15),
      new Employee("Mike", 51)
  );

  @Test
  void all_employees_over_18_years() {
    EmployeeReport report = new EmployeeReport(DATA_SOURCE_OF_EMPLOYEES);
    report.createListOfEmployeesAbleToWorkOnSundays().forEach(employee ->
        assertTrue(employee.age() >= 18)
    );
  }

  // Commented out due to contradiction with requirement 2.

//  @Test
//  void all_employees_ascending_order_by_name() {
//    EmployeeReport report = new EmployeeReport(employees);
//    List<Employee> actual = report.createListOfEmployeesAbleToWorkOnSundays();
//    List<Employee> expected = actual.stream()
//        .sorted(Comparator.comparing(Employee::getName))
//        .toList();
//    assertIterableEquals(expected, actual);
//  }

  @Test
  void all_employees_in_uppercase() {
    EmployeeReport report = new EmployeeReport(DATA_SOURCE_OF_EMPLOYEES);
    report.createListOfEmployeesAbleToWorkOnSundays().forEach(employee ->
        Arrays.stream(employee.name().split("")).forEach(name ->
            assertTrue(Character.isUpperCase(name.charAt(0)))
        )
    );
  }

  @Test
  void all_employees_descending_order_by_name() {
    EmployeeReport report = new EmployeeReport(DATA_SOURCE_OF_EMPLOYEES);
    List<Employee> actual = report.createListOfEmployeesAbleToWorkOnSundays();
    List<Employee> expected = actual.stream()
        .sorted(Comparator.comparing(Employee::name).reversed())
        .toList();
    assertIterableEquals(expected, actual);
  }
}
