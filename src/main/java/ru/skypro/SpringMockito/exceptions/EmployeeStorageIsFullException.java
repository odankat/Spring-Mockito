package ru.skypro.SpringMockito.exceptions;

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String massage) {
        super(massage);
    }
}
