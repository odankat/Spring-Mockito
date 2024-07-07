package ru.skypro.SpringMockito.departmentService;

import ru.skypro.SpringMockito.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface Idepartment {


    Map<Integer, List<Employee>> depaertments();

    ArrayList<Employee> employees(int department);

    int allSalaryDepartment(int id);





    int maxSalaryDepartment(int id);

    int minSalaryDepartment(int id);


}
