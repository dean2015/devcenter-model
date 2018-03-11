package cn.devcenter.model.authority;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Role implements Serializable {

    private Serializable id;

    private Serializable name;

    private Boolean enabled;

    private Serializable description;

}
