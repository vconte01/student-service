package it.linksmt.academy.micro.student.exception;

public class StudentNotFoundException extends RuntimeException{

    private final String message;

    public StudentNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
