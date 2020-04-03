package com.bhdx.DAO;

import com.bhdx.models.DetailMark;
import com.bhdx.models.KindDic;
import com.bhdx.models.LevelDic;

import java.util.List;

public interface SelectMapper {

    //查询学生all
    public List<DetailMark> findXCAll();

    List<KindDic> selectKind(String lableId);

    List<LevelDic> selectlevel(String kindId);
}



