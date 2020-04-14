package com.bhdx.service;


import com.bhdx.models.*;

import java.util.List;

public interface AddZsService {
    public boolean zcadd(ZCDetail zcDetail);

    public boolean cxadd(CXDetail cxDetail);

    public boolean findRepeat();

    //管理员添加分数创新
    boolean addMark(OutCX outCX);

    //管理员添加分数综测
    boolean addMarkZC(OutZC outZC);



}
