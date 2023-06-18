package com.cmm.design_patterns.chainOfResponsibility;

/**
 * 具体处理角色
 */
public class ProjectManagerHandler extends Handler {
    @Override
    public String handleFeeRequest(String user, double fee) {

        String str = "";
        // 项目经理权限比较小，只能在500以内
        if (fee < 500) {
            // 为了测试，简单点，只同意张三的请求
            if ("张三".equals(user)) {
                str = "成功：项目经理同意【" + user + "】的聚餐费用，金额为" + fee + "元";
            } else {
                // 其他人一律不同意
                str = "失败：项目经理不同意【" + user + "】的聚餐费用，金额为" + fee + "元";
            }
        } else {
            // 判断是否有后继的责任对象 如果有，就转发请求给后继的责任对象 如果没有，则处理请求
            // 超过500，继续传递给级别更高的人处理
            if (getSuccessor() != null) {
                return getSuccessor().handleFeeRequest(user, fee);
            }
        }
        return str;
    }
}