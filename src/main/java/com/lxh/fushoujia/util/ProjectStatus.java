package com.lxh.fushoujia.util;

/*
 * @PackageName: com.lxh.fushoujia.util
 * @ClassName: ProjectStatus
 * @Description:
 * @author: 辉
 * @date: 2019/10/30 0:40
 * */
public class ProjectStatus {
    public static final String toSave = "toSave"; //暂存
    public static final String toReview = "toReview"; //待审核
    public static final String toSend = "toSend"; //未派遣
    public static final String send = "send"; //派遣中
    public static final String toSendSecond = "toSendSecond"; //未派遣二级
    public static final String toApproval = "toApproval"; //待审批
    public static final String review = "review"; //已审核
    public static final String approval = "approval"; //已审批
    public static final String invalid = "invalid"; //已作废//
    public static final String noInvalid = "noInvalid"; //取消作废//
    public static final String toInvalid = "invalid"; //待作废//

    public static final String noReview = "noReview"; //审核未通过
    public static final String noApproval = "noApproval"; //审批未通过
    public static final String contract = "contract"; //已签合同
    public static final String noContract = "noContract"; //未签合同
    public static final String contractEnd = "contractEnd"; //合同终止
    public static final String payment = "payment"; //已收款
    public static final String noPayment = "noPayment"; //未收款
    public static final String finish = "finish"; //已完工
    public static final String accept = "accept"; //已验收
    public static final String noAccept = "noAccept"; //未验收

    public static final String sale = "sale"; //销售
    public static final String purchase = "purchase"; //采购

}
