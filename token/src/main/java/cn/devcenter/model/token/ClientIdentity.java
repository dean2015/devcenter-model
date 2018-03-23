package cn.devcenter.model.token;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ClientIdentity implements Serializable {

    private String clientIdentifier;

    private String device;

}
