package cn.devcenter.model.authentication;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Authentication implements Serializable{

    /**
     * The identifier of an authentication.
     */
    @Id
    private Serializable id;

    /**
     * The secret of an authentication.
     */
    private Serializable secret;

    /**
     * Reserved property, and what type of this authentication, as this is a third-party auth.
     */
    private Serializable type;

    /**
     * Reserved property, and it shows where this authentication is registered from.
     */
    private Serializable from;

}
