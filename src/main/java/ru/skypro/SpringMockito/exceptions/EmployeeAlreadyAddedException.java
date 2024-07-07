package ru.skypro.SpringMockito.exceptions;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException(String massage) {
        super(massage);
    }
}
