package com.bhdx.service;

import com.bhdx.models.DetailMark;
import com.bhdx.models.KindDic;
import com.bhdx.models.LevelDic;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SelectService {
    List<KindDic> selectKind(String lableId);

    List<LevelDic> selectlevel(String kindId);

    //细节+分数
    public List<DetailMark> findXC();


    public String getHeader(HttpServletRequest request);

    public boolean cchcx(String zsname);

    public boolean cchzc(String zsname);

    public String cchall(String zsname);
}
