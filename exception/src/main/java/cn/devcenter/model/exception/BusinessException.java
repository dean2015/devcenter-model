package cn.devcenter.model.exception;

/**
 * 应用内部必须要处理的异常. 此类异常可以转化为runtime异常,让上一层来决定是否处理
 *
 * @author gaosong
 */
public class BusinessException extends Exception {

    private static final long serialVersionUID = -893543915041247854L;

    public BusinessException() {
        super();
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

}
