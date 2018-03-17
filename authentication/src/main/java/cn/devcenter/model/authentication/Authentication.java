package cn.devcenter.model.authentication;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class Authentication implements Serializable {

    /**
     * The identifier of an authentication.
     */
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

    /**
     * Reserved property, and it shows which system this authentication is registered to.
     */
    private Serializable system;

}
