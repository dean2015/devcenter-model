package cn.devcenter.model.approval;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ApprovalProcess {

    private Serializable id;

    private Set<Serializable> approvers;

    private Serializable nextProcessId;

}
