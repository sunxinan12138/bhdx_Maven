package com.bhdx.tools;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

public class AjaxTool {
    public AjaxTool(List alist, HttpServletResponse response) {
        try {
            response.setHeader("Content-Type", "text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            Gson g = new Gson();
            String value = g.toJson(alist);
            out.print(value);// 返给ajax请求
            // 刷新
            out.flush();
            // 关闭
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    public AjaxTool(Boolean boo, HttpServletResponse response) {
        try {
            response.setHeader("Content-Type", "text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            Gson g = new Gson();
            String value = g.toJson(boo);
            out.print(value);// 返给ajax请求
            // 刷新
            out.flush();
            // 关闭
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    public AjaxTool(String str, HttpServletResponse response) {
        try {
            response.setHeader("Content-Type", "text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            Gson g = new Gson();
            String value = g.toJson(str);
            out.print(value);// 返给ajax请求
            // 刷新
            out.flush();
            // 关闭
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}
