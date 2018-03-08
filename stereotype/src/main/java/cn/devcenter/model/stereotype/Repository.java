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
@Component
@org.springframework.stereotype.Repository
public @interface Repository {

    String value() default "";

}
