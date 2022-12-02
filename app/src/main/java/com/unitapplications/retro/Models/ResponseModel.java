package com.unitapplications.retro.Models;

import java.util.List;

public class ResponseModel {
    String status;
    String message ;
    List<MemeModel> data;

    public ResponseModel(String status, String message, List<MemeModel> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<MemeModel> getData() {
        return data;
    }

    public void setData(List<MemeModel> data) {
        this.data = data;
    }
}