package cn.devcenter.model.authentication;

import cn.devcenter.model.repository.model.Record;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Data
@ApiModel
public class Authentication implements Serializable {

    /**
     * The identifier of an authentication.
     */
    private String id;

    /**
     * The secret of an authentication.
     */
    private String secret;

    /**
     * Reserved property, and what type of this authentication, as this is a third-party auth.
     */
    private String type;

    /**
     * Reserved property, and it shows where this authentication is registered from.
     */
    private String from;

    /**
     * Reserved property, and it shows which system this authentication is registered to.
     */
    private String system;

    /**
     * Record information.
     */
    private Record record;

}
