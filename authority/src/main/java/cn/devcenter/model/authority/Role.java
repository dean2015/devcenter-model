package cn.devcenter.model.authority;

import cn.devcenter.model.repository.model.Record;
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

    private Record record;

}
