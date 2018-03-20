package cn.devcenter.model.token;


import cn.devcenter.model.repository.model.Record;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AccessToken implements Serializable {

    private String id;

    private String token;

    private String refreshToken;

    private String from;

    private Boolean enabled;

    private Long expiredPeriod;

    private ClientIdentity clientIdentity;

    private UserIdentity userIdentity;

    private Record record;

}
