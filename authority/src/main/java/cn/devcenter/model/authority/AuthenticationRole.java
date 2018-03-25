package cn.devcenter.model.authority;

import cn.devcenter.model.repository.model.Record;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AuthenticationRole {

    private String id;

    private String uriId;

    private String roleId;

    private Record record;

}
