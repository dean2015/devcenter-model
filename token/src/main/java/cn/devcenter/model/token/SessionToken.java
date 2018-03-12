package cn.devcenter.model.token;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class SessionToken implements Serializable {

    private Serializable id;

    private Serializable accessToken;

    private Serializable from;

    private List<Serializable> roles;

    private Serializable userIdentifier;

    private Serializable requestId;

}
