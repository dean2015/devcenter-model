package cn.devcenter.model.token;


import cn.devcenter.model.repository.model.Record;
import lombok.*;

import java.beans.Transient;
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

    private RefreshToken refreshToken;

    private String from;

    private boolean enabled;

    private long expiredPeriod;

    private ClientIdentity clientIdentity;

    private UserIdentity userIdentity;

    private Record record;

    @Transient
    public boolean isExpired() {
        return System.currentTimeMillis() > record.getCreateTime() + expiredPeriod;
    }
}
