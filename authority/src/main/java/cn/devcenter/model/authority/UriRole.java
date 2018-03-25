package cn.devcenter.model.authority;

import cn.devcenter.model.repository.model.Record;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UriRole implements Serializable {

    private String id;

    private String uriId;

    private String roleId;

    private Boolean enabled;

    private Record record;

}
