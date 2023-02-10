package be.technobel.sandwich.exception;

import lombok.Getter;

@Getter
public class DemoException extends RuntimeException {

    private final Object innerData;

    public DemoException(Object innerData) {
        super("this is a demo");
        this.innerData = innerData;
    }

}
