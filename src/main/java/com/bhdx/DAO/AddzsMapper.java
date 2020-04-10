package com.bhdx.DAO;

import com.bhdx.models.CXDetail;
import com.bhdx.models.OutCX;
import com.bhdx.models.ZCDetail;

public interface AddzsMapper {
    void zcadd(ZCDetail zsDetail);

    void cxadd(CXDetail cxDetail);

    //管理员添加分
    void addMark(OutCX outCX);
}
