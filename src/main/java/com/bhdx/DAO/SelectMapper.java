package com.bhdx.DAO;

import com.bhdx.models.*;

import java.util.List;

public interface SelectMapper {

    //查询学生all
    public List<DetailMark> findXCAll();

    List<KindDic> selectKind(String lableId);

    List<LevelDic> selectlevel(String kindId);

    List<ZCDetail> findZcBistuid(String stuid);

    List<CXDetail> findCxBistuid(String stuid);

    void delById(String id);

    void delByIdZC(String id);

    //找证书详情
    List<DelMessage> finddelzs(String stuid);

    //删除不通过详情
    void deldel(String id);

    List<CXDetail> doshowImg(String id);
    //查找通过的证书创新

    List<OutCX> doTGCxSelectZsByStuid(String stuid);

    //查找通过的证书综测
    List<OutZC> doTGZcSelectZsByStuid(String stuid);


}



