package com.bhdx.service;

import com.bhdx.models.DetailMark;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SelectService {


    //细节+分数
    public List<DetailMark> findXC();


    public String getHeader(HttpServletRequest request);

    public boolean cchcx(String zsname);

    public boolean cchzc(String zsname);

    public String  cchall(String zsname);
}
