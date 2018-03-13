package cn.devcenter.model.token;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ClientIdentity implements Serializable {

    private Serializable id;

    private Serializable accessToken;

    private Serializable clientIdentifier;

    private Serializable device;

}
