package cn.devcenter.model.repository.exception;

public class NotSupportedException extends RuntimeException {

    public NotSupportedException() {
        super("The method is not supported.");
    }
}
