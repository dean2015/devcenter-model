package cn.devcenter.model.cache;

/**
 * Cache异常
 * @author gaosong
 *
 */
public class CacheException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 6516044320967055058L;

    /**
     * Creates a new <code>CacheException</code>.
     */
    public CacheException() {
        super();
    }

    /**
     * Creates a new <code>CacheException</code>.
     *
     * @param message
     *            the reason for the exception.
     */
    public CacheException(String message) {
        super(message);
    }

    /**
     * Creates a new <code>CacheException</code>.
     *
     * @param cause
     *            the underlying cause of the exception.
     */
    public CacheException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new <code>CacheException</code>.
     *
     * @param message
     *            the reason for the exception.
     * @param cause
     *            the underlying cause of the exception.
     */
    public CacheException(String message, Throwable cause) {
        super(message, cause);
    }
}
