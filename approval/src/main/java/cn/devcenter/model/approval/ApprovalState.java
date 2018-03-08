package cn.devcenter.model.approval;

public enum ApprovalState {
    /**
     * 初始化状态，没有审批结果的状态
     */
    INIT,
    /**
     * 审批同意
     */
    APPROVED,
    /**
     * 审批拒绝
     */
    REJECTED;

}
