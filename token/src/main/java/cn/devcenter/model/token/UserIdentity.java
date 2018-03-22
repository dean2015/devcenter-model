package cn.devcenter.model.token;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserIdentity implements Serializable {

    private String id;

    private String accessToken;

    private String userIdentifier;

    private String authenticationId;

    private List<String> roles;

}
