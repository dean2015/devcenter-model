package cn.devcenter.model.authority;

import cn.devcenter.model.repository.model.Record;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UriRole implements Serializable {

    @Id
    private String id;

    private String uriId;

    private String roleId;

    private Boolean enabled;

    private Record record;

}
