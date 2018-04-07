package cn.devcenter.model.exception;

/**
 * 标识程序类异常，应用内部必须要处理的异常.
 * 
 * @author gaosong
 *
 */
public class ApplicationException extends Exception {

    private static final long serialVersionUID = 993543915041247854L;

    public ApplicationException() {
        super();
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

}
