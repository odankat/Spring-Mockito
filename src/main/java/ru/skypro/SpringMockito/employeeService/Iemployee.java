package ru.skypro.SpringMockito.employeeService;

import ru.skypro.SpringMockito.Employee;

import java.util.Collection;

public interface Iemployee {
    String addEmployee(String fullname, int department, int salary);

    String removeEmployee(String fullname);

    Collection<Employee> findAll();


    Employee findThis(String fullName);
}
