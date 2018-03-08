package cn.devcenter.model.template.api.exception;

public class NotSupportedException extends RuntimeException {

    public NotSupportedException() {
        super("The method is not supported.");
    }
}
