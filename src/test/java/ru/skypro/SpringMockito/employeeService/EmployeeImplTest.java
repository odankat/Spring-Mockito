package ru.skypro.SpringMockito.employeeService;

import ru.skypro.SpringMockito.Employee;
import org.junit.jupiter.api.Test;
import ru.skypro.SpringMockito.exceptions.EmployeeAlreadyAddedException;
import ru.skypro.SpringMockito.exceptions.EmployeeNotFoundException;
import ru.skypro.SpringMockito.exceptions.EmployeeStorageIsFullException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeImplTest {

    private final EmployeeImpl employeeImpl = new EmployeeImpl();

    @Test
    public void corectAddEmployee() {
        Employee expectedEmployee = new Employee("Петя", 1, 100);
        String expected = expectedEmployee.toString();
        String actual = employeeImpl.addEmployee("Петя", 1, 100);
        assertEquals(expected, actual);
    }

    @Test
    public void correctEjectionEmployeeAlreadyAddedException() {
        Employee employee = new Employee("Петя", 1, 100);
        employeeImpl.addEmployee("Петя", 1, 100);
        assertThrows(
                EmployeeAlreadyAddedException.class,
                () -> employeeImpl.addEmployee("Петя", 1, 100));
    }

    @Test
    public void correctEjectionEmployeeStorageIsFullException() {
        for (int i = 0; i < employeeImpl.maxEmployee; i++) {
            employeeImpl.addEmployee("petya" + i, 1, 100);
        }
        assertThrows(
                EmployeeStorageIsFullException.class,
                () -> employeeImpl.addEmployee("petya", 1, 100)
        );

    }

    @Test
    void correctRemoveEmployee() {
        String fullName = "Петя";
        employeeImpl.addEmployee("Петя", 1, 100);
        String expected = fullName + " сотрудник удален";
        String actual = employeeImpl.removeEmployee(fullName);
        assertEquals(expected, actual);
    }

    @Test
    void correctEjectionEmployeeNotFoundExceptionRemoveEmployee() {
        assertThrows(
                EmployeeNotFoundException.class,
                () -> employeeImpl.removeEmployee("Петка"));

    }

    @Test
    void correctEjectionEmployeeNotFoundExceptionFindThis() {
        assertThrows(
                EmployeeNotFoundException.class,
                () -> employeeImpl.findThis("Петька"));
    }



    @Test
    void correctFindThis() {
        employeeImpl.addEmployee("Петя", 1, 100);
        String actual = employeeImpl.findThis("Петя") + "";
        Employee employee = new Employee(("Петя"), 1, 100);
        String expected = employee.toString() + "";
        assertEquals(actual,expected);

    }
}