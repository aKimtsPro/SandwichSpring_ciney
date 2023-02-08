package be.technobel.sandwich.exception;

public class EmailAlreadyTakenException extends RuntimeException {

    public EmailAlreadyTakenException() {
        super("the specified email is already taken");
    }
}
