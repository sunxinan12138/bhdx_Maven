package com.bhdx.service;


import com.bhdx.models.CXDetail;
import com.bhdx.models.OutCX;
import com.bhdx.models.ZCDetail;

public interface AddZsService {
    public boolean zcadd(ZCDetail zcDetail);

    public boolean cxadd(CXDetail cxDetail);

    public boolean findRepeat();

    //管理员添加分数
    boolean addMark(OutCX outCX);

}
