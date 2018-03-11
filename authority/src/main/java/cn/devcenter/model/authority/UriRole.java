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

    private Serializable id;

    private Serializable uri;

    private Set<Serializable> allowedRoles;

    private Set<Serializable> forbiddenRoles;

    private Serializable description;

    private Boolean enabled;

}
