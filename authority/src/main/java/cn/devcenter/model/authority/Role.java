package cn.devcenter.model.authority;

import cn.devcenter.model.repository.model.Record;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(hidden = true)
    private Record record;

}
