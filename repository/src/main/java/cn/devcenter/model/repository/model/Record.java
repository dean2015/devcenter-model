package cn.devcenter.model.repository.model;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class Record {

    private Date createTime;

    private Date lastModifiedTime;

}
