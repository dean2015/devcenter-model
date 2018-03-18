package cn.devcenter.model.authority;

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

}
