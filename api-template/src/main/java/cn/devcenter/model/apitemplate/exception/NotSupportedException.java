package cn.devcenter.model.apitemplate.exception;

public class NotSupportedException extends RuntimeException {

    public NotSupportedException() {
        super("The method is not supported.");
    }
}
