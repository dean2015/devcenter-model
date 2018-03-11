package cn.devcenter.model.token;


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

    private Serializable id;

    private Serializable token;

    private Serializable refreshToken;

    private Serializable device;

    private List<Serializable> roles;

    private Long createTime;

    private Long expiredPeriod;

}
