package cn.devcenter.model.stereotype;

import java.lang.annotation.*;

/**
 *
 * @author gaosong
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@org.springframework.stereotype.Component
public @interface Component {

    String value() default "";

}
