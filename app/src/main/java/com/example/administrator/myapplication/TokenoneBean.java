package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2019/11/22.
 */

public class TokenoneBean {

    /**
     * ResultObj : 04f262bf-186f-4c54-bc5a-abbb159bb3fa
     * Status : 1
     * StatusCode : 0
     * Msg : 可能设备ID【60367】还未上线！
     * ErrorObj : null
     */

    private String ResultObj;
    private int Status;
    private int StatusCode;
    private String Msg;
    private Object ErrorObj;

    public String getResultObj() {
        return ResultObj;
    }

    public void setResultObj(String ResultObj) {
        this.ResultObj = ResultObj;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public Object getErrorObj() {
        return ErrorObj;
    }

    public void setErrorObj(Object ErrorObj) {
        this.ErrorObj = ErrorObj;
    }
}
