package cn.devcenter.model.organization;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Organization {

    private Serializable id;

    private Serializable name;

    private List<Serializable> subOrgs;

    private List<Serializable> itemIds;

}
