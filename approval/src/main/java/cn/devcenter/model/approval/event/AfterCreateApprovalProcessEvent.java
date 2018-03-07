package cn.devcenter.model.approval.event;

import cn.devcenter.model.approval.ApprovalProcess;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AfterCreateApprovalProcessEvent implements Serializable {

    private ApprovalProcess approvalProcess;

}
