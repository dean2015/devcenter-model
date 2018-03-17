package cn.devcenter.model.repository.model;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class Record implements Serializable {

    private Long createTime;

    private Long lastModifiedTime;

}
