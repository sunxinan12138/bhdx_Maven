package com.bhdx.service;

import com.bhdx.models.DetailMark;
import com.bhdx.models.JIngFei_mark;
import com.bhdx.models.JingFei;
import org.omg.CORBA.INTERNAL;

import java.util.List;

public interface SelectService {
    //竞赛非
    public List<JingFei> findJF();

    //竞赛科技
    public List<JingFei> findJK();

    public List<JingFei> findKF();

    public List<JingFei> findKK();

    public List<JingFei> findZZ();

    public List<JingFei> findZQ();

    public List<JingFei> findHK();

    public List<JingFei> findHS();

    public List<JingFei> findHST();

    public List<JingFei> findHX();

    public List<JingFei> findHSZ();


    //查分数
    public List<JIngFei_mark> findjkmark();

    public List<JIngFei_mark> findmark(Integer id);

    public List<JIngFei_mark> findkkmark(Integer id);

    public List<JIngFei_mark> findkfmark(Integer id);

    public List<JIngFei_mark> findzqMark(Integer id);

    public List<JIngFei_mark> findhkMark(Integer id);

    public List<JIngFei_mark> findhsMark(Integer id);

    public List<JIngFei_mark> findhstMark(Integer id);


    //细节+分数
    public List<DetailMark> findXC();

    //改名查詢 到mark
    public List<JIngFei_mark> findzzMark();

    public List<JIngFei_mark> findhxMark();

    public List<JIngFei_mark> findhszMark();
}
