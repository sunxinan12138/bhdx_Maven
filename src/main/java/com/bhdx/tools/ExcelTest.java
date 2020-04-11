package com.bhdx.tools;

import com.bhdx.models.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelTest {
    //创新
    public ExcelTest(List<Student> studentList, String classid, String path) {
        try {
            //2007版本
            Workbook workbook = new XSSFWorkbook();
            //创建一个sheet
            Sheet sheet = workbook.createSheet("class1");
            // 写单元格
            //行列
            Row rowt = sheet.createRow(0);
            Cell cellt = rowt.createCell(0);
            cellt.setCellValue(classid + "班级");
            String[] title = {"学号", "姓名", "证书", "分数", "类别"};
            Row row = sheet.createRow(1);
            for (int i = 0; i < title.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(title[i]);
            }
            for (int i = 0; i < studentList.size(); i++) {
                Row row1 = sheet.createRow(i + 2);
                Cell cell = row1.createCell(0);
                cell.setCellValue(studentList.get(i).getId());
                Cell cell1 = row1.createCell(1);
                cell1.setCellValue(studentList.get(i).getName());
                for (int j = 0; j < studentList.get(i).getOutCXList().size(); j++) {
                    Cell cell2 = row1.createCell(2 + 3 * j);
                    cell2.setCellValue(studentList.get(i).getOutCXList().get(j).getZsName());
                    Cell cell3 = row1.createCell(3 + 3 * j);
                    cell3.setCellValue(studentList.get(0).getOutCXList().get(j).getMark());
                    Cell cell4 = row1.createCell(4 + 3 * j);
                    cell4.setCellValue(studentList.get(0).getOutCXList().get(j).getSort());
                }
            }

            FileOutputStream out = new FileOutputStream(path);

            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //综测
    public ExcelTest(String path, List<Student> studentList, String classid) {
        try {
            //2007版本
            Workbook workbook = new XSSFWorkbook();
            //创建一个sheet
            Sheet sheet = workbook.createSheet("class1");
            // 写单元格
            //行列
            Row rowt = sheet.createRow(0);
            Cell cellt = rowt.createCell(0);
            cellt.setCellValue(classid + "班级");
            String[] title = {"学号", "姓名", "证书", "分数", "类别"};
            Row row = sheet.createRow(1);
            for (int i = 0; i < title.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(title[i]);
            }
            for (int i = 0; i < studentList.size(); i++) {
                Row row1 = sheet.createRow(i + 2);
                Cell cell = row1.createCell(0);
                cell.setCellValue(studentList.get(i).getId());
                Cell cell1 = row1.createCell(1);
                cell1.setCellValue(studentList.get(i).getName());
                for (int j = 0; j < studentList.get(i).getOutZCList().size(); j++) {
                    Cell cell2 = row1.createCell(2 + 3 * j);
                    cell2.setCellValue(studentList.get(i).getOutZCList().get(j).getZsName());
                    Cell cell3 = row1.createCell(3 + 3 * j);
                    cell3.setCellValue(studentList.get(0).getOutZCList().get(j).getMark());
                    Cell cell4 = row1.createCell(4 + 3 * j);
                    cell4.setCellValue(studentList.get(0).getOutZCList().get(j).getZk());
                }
            }

            FileOutputStream out = new FileOutputStream(path);

            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
