package com.example.administrator.myapplication;

import java.util.List;

/**
 * Created by Administrator on 2019/11/20.
 */

public class TokenActivity {

    /**
     * ResultObj : [{"Unit":"℃","ApiTag":"z_temperature","Groups":1,"Protocol":2,"Name":"温度","CreateDate":"2019-11-15 13:52:12","TransType":0,"DataType":1,"TypeAttrs":"","DeviceID":60367,"SensorType":"temperature","Value":-0.1,"RecordTime":"2019-11-18 11:10:04"},{"Unit":"%RH","ApiTag":"z_humidity","Groups":1,"Protocol":2,"Name":"湿度","CreateDate":"2019-11-15 13:52:34","TransType":0,"DataType":1,"TypeAttrs":"","DeviceID":60367,"SensorType":"humidity","Value":0,"RecordTime":"2019-11-18 11:10:04"},{"Unit":"lx","ApiTag":"z_light","Groups":1,"Protocol":2,"Name":"光照","CreateDate":"2019-11-15 13:54:03","TransType":0,"DataType":1,"TypeAttrs":"","DeviceID":60367,"SensorType":"light","Value":"","RecordTime":""},{"OperType":1,"OperTypeAttrs":"","ApiTag":"rupxrokrqewz","Groups":2,"Protocol":2,"Name":"单联继电器","CreateDate":"2019-11-15 13:55:07","TransType":1,"DataType":2,"TypeAttrs":"","DeviceID":60367,"SensorType":"","Value":true,"RecordTime":"2019-11-18 11:14:05"},{"OperType":1,"OperTypeAttrs":"","ApiTag":"ufodhdmndupl","Groups":2,"Protocol":2,"Name":"双联第一联","CreateDate":"2019-11-15 13:56:47","TransType":1,"DataType":2,"TypeAttrs":"","DeviceID":60367,"SensorType":"","Value":false,"RecordTime":"2019-11-18 11:19:04"},{"OperType":1,"OperTypeAttrs":"","ApiTag":"ztynaxmpbgmw","Groups":2,"Protocol":2,"Name":"双联第二联","CreateDate":"2019-11-15 13:57:17","TransType":1,"DataType":2,"TypeAttrs":"","DeviceID":60367,"SensorType":"","Value":false,"RecordTime":"2019-11-18 11:19:04"}]
     * Status : 0
     * StatusCode : 0
     * Msg : null
     * ErrorObj : null
     */

    private int Status;
    private int StatusCode;
    private Object Msg;
    private Object ErrorObj;
    private List<ResultObjBean> ResultObj;

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

    public Object getMsg() {
        return Msg;
    }

    public void setMsg(Object Msg) {
        this.Msg = Msg;
    }

    public Object getErrorObj() {
        return ErrorObj;
    }

    public void setErrorObj(Object ErrorObj) {
        this.ErrorObj = ErrorObj;
    }

    public List<ResultObjBean> getResultObj() {
        return ResultObj;
    }

    public void setResultObj(List<ResultObjBean> ResultObj) {
        this.ResultObj = ResultObj;
    }

    public static class ResultObjBean {
        /**
         * Unit : ℃
         * ApiTag : z_temperature
         * Groups : 1
         * Protocol : 2
         * Name : 温度
         * CreateDate : 2019-11-15 13:52:12
         * TransType : 0
         * DataType : 1
         * TypeAttrs :
         * DeviceID : 60367
         * SensorType : temperature
         * Value : -0.1
         * RecordTime : 2019-11-18 11:10:04
         * OperType : 1
         * OperTypeAttrs :
         */

        private String Unit;
        private String ApiTag;
        private int Groups;
        private int Protocol;
        private String Name;
        private String CreateDate;
        private int TransType;
        private int DataType;
        private String TypeAttrs;
        private int DeviceID;
        private String SensorType;
        private String Value;
        private String RecordTime;
        private int OperType;
        private String OperTypeAttrs;

        public String getUnit() {
            return Unit;
        }

        public void setUnit(String Unit) {
            this.Unit = Unit;
        }

        public String getApiTag() {
            return ApiTag;
        }

        public void setApiTag(String ApiTag) {
            this.ApiTag = ApiTag;
        }

        public int getGroups() {
            return Groups;
        }

        public void setGroups(int Groups) {
            this.Groups = Groups;
        }

        public int getProtocol() {
            return Protocol;
        }

        public void setProtocol(int Protocol) {
            this.Protocol = Protocol;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getCreateDate() {
            return CreateDate;
        }

        public void setCreateDate(String CreateDate) {
            this.CreateDate = CreateDate;
        }

        public int getTransType() {
            return TransType;
        }

        public void setTransType(int TransType) {
            this.TransType = TransType;
        }

        public int getDataType() {
            return DataType;
        }

        public void setDataType(int DataType) {
            this.DataType = DataType;
        }

        public String getTypeAttrs() {
            return TypeAttrs;
        }

        public void setTypeAttrs(String TypeAttrs) {
            this.TypeAttrs = TypeAttrs;
        }

        public int getDeviceID() {
            return DeviceID;
        }

        public void setDeviceID(int DeviceID) {
            this.DeviceID = DeviceID;
        }

        public String getSensorType() {
            return SensorType;
        }

        public void setSensorType(String SensorType) {
            this.SensorType = SensorType;
        }

        public String getValue() {
            return Value;
        }

        public void setValue(String Value) {
            this.Value = Value;
        }

        public String getRecordTime() {
            return RecordTime;
        }

        public void setRecordTime(String RecordTime) {
            this.RecordTime = RecordTime;
        }

        public int getOperType() {
            return OperType;
        }

        public void setOperType(int OperType) {
            this.OperType = OperType;
        }

        public String getOperTypeAttrs() {
            return OperTypeAttrs;
        }

        public void setOperTypeAttrs(String OperTypeAttrs) {
            this.OperTypeAttrs = OperTypeAttrs;
        }
    }
}
