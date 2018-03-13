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

    private Serializable id;

    private Serializable accessToken;

    private Serializable userIdentifier;

    private Serializable userId;

    private List<Serializable> roles;

}
