package com.bhdx.DAO;

import com.bhdx.models.CXDetail;
import com.bhdx.models.DelMessage;
import com.bhdx.models.OutCX;

import java.util.List;

public interface CXManagerMapper {
    List<CXDetail> selectCXByClass(String classId);// 根据班级号查询创新分

    void deleteCXById(int CXid);//根据证书编号删除证书

    void updateCXById(CXDetail cxDetail);//根据证书编号修改证书详情

    List<CXDetail> selectCXById(int id);//通过证书编号查询证书

    void insertOutCX(OutCX outCX);//通过审核

    void insertDelMessage(DelMessage delMessage);//审核不通过

}
