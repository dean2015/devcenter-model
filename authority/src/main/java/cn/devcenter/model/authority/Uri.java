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
public class Uri implements Serializable {

    private String id;

    private String uri;

    private String description;

    private Boolean serviceId;

    private Record record;

}
