package cn.devcenter.model.repository.model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class Record implements Serializable {

    private long createTime;

    private long lastModifiedTime;

}
