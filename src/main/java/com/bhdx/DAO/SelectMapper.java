package com.bhdx.DAO;

import com.bhdx.models.DetailMark;
import com.bhdx.models.JIngFei_mark;
import com.bhdx.models.JingFei;

import java.util.List;

public interface SelectMapper {
    public List<JingFei> findJF();

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


    //分数查询
    public List<JIngFei_mark> findjfmark();

    public List<JIngFei_mark> findJFmark(Integer id);

    public List<JIngFei_mark> findKKmark(Integer id);

    public List<JIngFei_mark> findKFmark(Integer id);

    public List<JIngFei_mark> findZQmark(Integer id);

    public List<JIngFei_mark> findHKmark(Integer id);

    public List<JIngFei_mark> findHSmark(Integer id);

    public List<JIngFei_mark> findHSTmark(Integer id);

    //查询学生all
    public List<DetailMark> findXCAll();

    //改名查询mark全
    public List<JIngFei_mark> findzzMark();

    public List<JIngFei_mark> findhxMark();

    public List<JIngFei_mark> findhszMark();
}
