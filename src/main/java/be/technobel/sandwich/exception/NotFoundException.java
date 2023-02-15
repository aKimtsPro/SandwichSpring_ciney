package be.technobel.sandwich.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super("element could not be foun");
    }
}
