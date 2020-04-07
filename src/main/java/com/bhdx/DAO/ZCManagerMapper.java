package com.bhdx.DAO;

import com.bhdx.models.OutZC;
import com.bhdx.models.SubjectClass;
import com.bhdx.models.ZCDetail;
import com.bhdx.models.ZK;

import java.util.List;

public interface ZCManagerMapper {
    List<ZCDetail> getZCByClass(String classId);//根据班级号查询综测
    List<SubjectClass> selectAllClass();//查询所有班级
    void deleteZCById(int ZCid);//根据证书编号删除证书
    List<ZCDetail> getZCById(int id);//根据证书编号查询证书
    void insertOutZC(OutZC outZC);//审核通过
    void updateZCById(ZCDetail zcDetail);//更新综测证书
    List<ZK> selectZK(); //查询折扣表

}
