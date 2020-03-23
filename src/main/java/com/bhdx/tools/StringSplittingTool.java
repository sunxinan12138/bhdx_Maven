package com.bhdx.tools;

import com.bhdx.models.Admin;

public class StringSplittingTool {
    //2017 1605 01
    //电子 17级 1班
    public String  GetSubject(String ID){
         String Subject = ID.substring(4,8);
         switch (Subject){
             case "1601" : Subject = "测控";
             break;
             case "1602" : Subject = "电气";
             break;
             case "1603" : Subject = "信息";
             break;
             case "1604" : Subject = "通信";
             break;
             case "1605" : Subject = "电子";
             break;
             case "1606" : Subject = "自动化";
             break;
             case "1607" : Subject = "通合作";
         }
         String New_ID=Subject+ID.substring(2,4)+"级"+ID.substring(9,10)+"班";
         return New_ID;
     }

     public String GetSubjectID (String ID){
        String SubjectID = ID.substring(2,10);
        return SubjectID;
     }
}
