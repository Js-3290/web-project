package com.js.pojo;

import java.util.List;

//统计活动类型
public class TypeOption {
    private List typeList;
    private List dataList;






    @Override
    public String toString() {
        return "TypeOption{" +
                "typeList=" + typeList +
                ", dataList=" + dataList +
                '}';
    }

    public List getTypeList() {
        return typeList;
    }

    public void setTypeList(List typeList) {
        this.typeList = typeList;
    }

    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }

    public TypeOption() {
    }

    public TypeOption(List typeList, List dataList) {
        this.typeList = typeList;
        this.dataList = dataList;
    }
}
