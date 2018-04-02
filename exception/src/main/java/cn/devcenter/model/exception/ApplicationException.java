package cn.devcenter.model.exception;

/**
 * 应用内部必须要处理的异常. 此类异常可以转化为runtime异常,让上一层来决定是否处理
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
