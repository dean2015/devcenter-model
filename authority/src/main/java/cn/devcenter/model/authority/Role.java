package cn.devcenter.model.authority;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Role implements Serializable {

    private String id;

    private String name;

    private Boolean enabled;

    private String description;

}
