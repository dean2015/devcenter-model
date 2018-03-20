package cn.devcenter.model.token;


import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RefreshToken implements Serializable {

    private String id;

    private String refreshToken;

    private String accessToken;

    private Long createTime;

    private Long LastUsedAt;

    private Long expiredPeriod;
}
