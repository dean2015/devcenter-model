package cn.devcenter.model.result;

import lombok.Data;

@Data
public class ExecutionResult<E> {

    public static final int SUCCESS = 0;

    public static final int FAIL = -1;

    public ExecutionResult() {
    }

    public static <T> ExecutionResult<T> newInstance() {
        return new ExecutionResult<T>();
    }

    public static <T> ExecutionResult<T> newInstance(Class<T> clazz) {
        return new ExecutionResult<T>();
    }

    public ExecutionResult<E> success(String message, E data) {
        this.code = SUCCESS;
        this.message = message;
        this.data = data;
        return this;
    }

    public ExecutionResult<E> success(E data) {
        this.code = SUCCESS;
        this.message = "";
        this.data = data;
        return this;
    }

    public ExecutionResult<E> success(String message) {
        this.code = SUCCESS;
        this.message = message;
        return this;
    }

    public ExecutionResult<E> fail(Integer code, String message, E data) {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }

    public ExecutionResult<E> fail(Integer code, String message) {
        this.code = code;
        this.message = message;
        return this;
    }

    public ExecutionResult<E> fail(String message, E data) {
        return fail(FAIL, message, data);
    }

    public ExecutionResult<E> fail(String message) {
        return fail(FAIL, message);
    }

    private Integer code;
    private String message;
    private E data;

    public boolean isSuccessful() {
        return code == SUCCESS;
    }

}
