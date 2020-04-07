package com.bhdx.service;

import com.bhdx.models.*;

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

    //查询zc证书 by学号
    List<CXDetail> findCxBistuid(String stuid);

    //查询zc证书 by学号
    List<ZCDetail> findZcBistuid(String stuid);
}
