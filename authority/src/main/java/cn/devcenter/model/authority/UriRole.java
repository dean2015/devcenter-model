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

    private String uri;

    private Set<String> allowedRoles;

    private Set<String> forbiddenRoles;

    private String description;

    private Boolean enabled;

    private Record record;

}
