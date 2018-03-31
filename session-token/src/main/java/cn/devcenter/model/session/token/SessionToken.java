package cn.devcenter.model.session.token;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class SessionToken implements Serializable {

    private String id;

    private String accessToken;

    private String from;

    private String userIdentifier;

    private String requestId;

}
