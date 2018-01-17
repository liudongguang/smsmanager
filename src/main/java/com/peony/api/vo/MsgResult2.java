package com.peony.api.vo;

/**
 *
 */
public class MsgResult2 {
    private int code;
    private String returnstatus;//返回状态
    private String message;//操作信息
    private int remainpoint;
    private String taskID;
    private int successCounts;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getReturnstatus() {
        return returnstatus;
    }

    public void setReturnstatus(String returnstatus) {
        this.returnstatus = returnstatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRemainpoint() {
        return remainpoint;
    }

    public void setRemainpoint(int remainpoint) {
        this.remainpoint = remainpoint;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public int getSuccessCounts() {
        return successCounts;
    }

    public void setSuccessCounts(int successCounts) {
        this.successCounts = successCounts;
    }
    @Override
    public String toString() {
        return "MsgResult2{" +
                "code=" + code +
                ", returnstatus='" + returnstatus + '\'' +
                ", message='" + message + '\'' +
                ", remainpoint=" + remainpoint +
                ", taskID='" + taskID + '\'' +
                ", successCounts=" + successCounts +
                '}';
    }

}
