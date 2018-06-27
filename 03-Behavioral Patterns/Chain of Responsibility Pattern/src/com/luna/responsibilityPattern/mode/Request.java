package com.luna.responsibilityPattern.mode;

/**
 * 请假对象
 *
 */
public class Request {
    //姓名
    private String name;
    //请假理由
    private String reason;
    //请假天数
    private int days;
    //组长意见
    private String teamLeaderInfo;
    //经理意见
    private String managerInfo;
    //部门领导意见
    private String departmentHeaderInfo;
    //备注
    private String customInfo;

    public Request(Builder builder) {
        super();
        this.name = builder.name;
        this.reason = builder.reason;
        this.days = builder.days;
        this.teamLeaderInfo = builder.groupLeaderInfo;
        this.managerInfo = builder.managerInfo;
        this.departmentHeaderInfo = builder.departmentHeaderInfo;
        this.customInfo = builder.customInfo;
    }

    /**
     * 通过建造者模式构建请假对象
     */
    public static class Builder {
        public String name;
        public String reason;
        public int days;
        public String groupLeaderInfo;
        public String managerInfo;
        public String departmentHeaderInfo;
        public String customInfo;

        public Builder() {
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setReason(String reason) {
            this.reason = reason;
            return this;
        }
        public Builder setDays(int days) {
            this.days = days;
            return this;
        }
        public Builder setGroupLeaderInfo(String groupLeaderInfo) {
            this.groupLeaderInfo = groupLeaderInfo;
            return this;
        }
        public Builder setManagerInfo(String managerInfo) {
            this.managerInfo = managerInfo;
            return this;
        }
        public Builder setDepartmentHeaderInfo(String departmentHeaderInfo) {
            this.departmentHeaderInfo = departmentHeaderInfo;
            return this;
        }
        public Builder setCustomInfo(String customInfo) {
            this.customInfo = customInfo;
            return this;
        }
        public Builder newRequest(Request request) {
            this.name = request.name;
            this.days = request.days;
            this.reason = request.reason;
            if (request.teamLeaderInfo != null
                    && !request.teamLeaderInfo.equals("")) {
                this.groupLeaderInfo = request.teamLeaderInfo;
            }
            if (request.managerInfo != null && !request.managerInfo.equals("")) {
                this.managerInfo = request.managerInfo;
            }
            if (request.departmentHeaderInfo != null
                    && !request.departmentHeaderInfo.equals("")) {
                this.departmentHeaderInfo = request.departmentHeaderInfo;
            }
            if (request.customInfo != null && !request.customInfo.equals("")) {
                this.customInfo = request.customInfo;
            }
            return this;
        }

        public Request build() {
            return new Request(this);
        }
    }
    public String name() {
        return name;
    }
    public String reason() {
        return reason;
    }
    public int days() {
        return days;
    }
    public String groupLeaderInfo() {
        return teamLeaderInfo;
    }
    public String managerInfo() {
        return managerInfo;
    }
    public String departmentHeaderInfo() {
        return departmentHeaderInfo;
    }
    public String customInfo() {
        return customInfo;
    }
    @Override
    public String toString() {
        return "Request [name=" + name + ", reason=" + reason + ", days="
                + days + ",customInfo=" + customInfo + ", groupLeaderInfo="
                + teamLeaderInfo + ", managerInfo=" + managerInfo
                + ", departmentHeaderInfo=" + departmentHeaderInfo + "]";
    }
}

