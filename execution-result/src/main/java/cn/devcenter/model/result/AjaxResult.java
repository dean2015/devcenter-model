package cn.devcenter.model.result;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

/**
 * REST接口同意返回值
 *
 * @author gaosong
 * @version 1.0
 * @name: AjaxResult
 */
@Data
public class AjaxResult<E> {

    public static final int SUCCESS = 0;

    public static final int FAIL = -1;

    public AjaxResult() {
    }

    public static <T> AjaxResult<T> newInstance() {
        return new AjaxResult<T>();
    }

    public static <T> AjaxResult<T> newInstance(Class<T> clazz) {
        return new AjaxResult<T>();
    }

    public AjaxResult<E> success(String message, E data) {
        this.code = SUCCESS;
        this.message = message;
        this.data = data;
        return this;
    }

    public AjaxResult<E> success(String message) {
        this.code = SUCCESS;
        this.message = message;
        return this;
    }

    public AjaxResult<E> fail(Integer code, String message, E data) {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }

    public AjaxResult<E> fail(Integer code, String message) {
        this.code = code;
        this.message = message;
        return this;
    }

    public AjaxResult<E> fail(String message, E data) {
        return fail(FAIL, message, data);
    }

    public AjaxResult<E> fail(String message) {
        return fail(FAIL, message);
    }


    /**
     * 处理结果 1: 成功 0: 失败
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 要返回的数据
     */
    /**
     * 返回信息
     */
    private E data;

    public boolean successful() {
        return getCode() == SUCCESS;
    }

    private static final Gson GSON = new GsonBuilder()
            .serializeNulls()
            .create();

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
