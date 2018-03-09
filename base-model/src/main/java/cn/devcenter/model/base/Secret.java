package cn.devcenter.model.base;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Secret {

    private Serializable secret;

}
