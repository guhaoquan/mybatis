package com.abc.vo;

public class QueryParam {
    private String paramName;
    private Integer paramId;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    @Override
    public String toString() {
        return "QueryParam{" +
                "paramName='" + paramName + '\'' +
                ", paramId=" + paramId +
                '}';
    }
}
