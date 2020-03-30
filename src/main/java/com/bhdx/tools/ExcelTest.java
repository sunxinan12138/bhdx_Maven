package com.bhdx.tools;

import com.bhdx.models.Student;
import com.bhdx.models.SubjectClass;
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
    @Test
    public void test() {
        try {
            //2007版本
            Workbook workbook = new XSSFWorkbook();
            //创建一个sheet
            Sheet sheet = workbook.createSheet("class1");
            // 写单元格
            //行列
            Row rowt = sheet.createRow(0);
            Cell cellt = rowt.createCell(0);
            cellt.setCellValue("班级");
            String[] title = {"学号", "姓名", "证书", "分数"};
            String[] study = {"1", "2", "3", "4"};
            String[] zs = {"1zs", "1zs", "1zs", "1zs"};
            Row row = sheet.createRow(1);
            for (int i = 0; i < title.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(title[i]);
            }
            for (int i = 0; i < study.length; i++) {
                Row row1 = sheet.createRow(i + 2);
                Cell cell = row1.createCell(0);
                System.out.println("www");
                cell.setCellValue(study[i]);
                for (int j = 0; j < zs.length; j++) {
                    System.out.println("ininiinin");
                    Cell cell2 = row1.createCell(2 + 2 * j);
                    Cell cell3 = row1.createCell(3 + 2 * j);
                    cell2.setCellValue(zs[j]);
                    cell3.setCellValue("分数");
                }
            }
            FileOutputStream out = new FileOutputStream("E:\\Business业务\\电气学院综测系统\\excel\\tset.xlsx");
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
