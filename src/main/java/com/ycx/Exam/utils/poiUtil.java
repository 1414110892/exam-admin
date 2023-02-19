package com.ycx.Exam.utils;

import com.ycx.Exam.entity.Subject;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

public class poiUtil {
    //读取excel
    public static Collection<Subject> ReadExcel(String inputFilePath, int rowBegin) throws IOException {
        FileInputStream fileInput = new FileInputStream(inputFilePath);//创建文件输入流
        XSSFWorkbook wb = new XSSFWorkbook(fileInput);//由输入流文件得到工作簿对象
        //System.out.println("xssfWorkbook对象：" + wb);

        XSSFSheet sheet = wb.getSheetAt(0);//获取第一个sheet
        int lastRowNum = sheet.getLastRowNum(); //获取表格内容的最后一行的行数

        Collection<Subject> subjectCollection = new ArrayList<>();
        Subject subject = null;

        //rowBegin代表要开始读取的行号，下面这个循环的作用是读取每一行内容
        for (int i = rowBegin; i <= lastRowNum; ++i) {
            XSSFRow row = sheet.getRow(i);//获取每一行
            int columnNum = row.getLastCellNum();//获取每一行的最后一列的列号，即总列数
            subject = new Subject();
            for (int j=0; j<columnNum; ++j) {
                XSSFCell cell = row.getCell(j);//获取每个单元格
                //设置单元格类型
                if(cell == null){
//                    System.out.print("  ");
                    continue;
                }
                cell.setCellType(CellType.STRING);
                //获取单元格数据
                String cellValue = cell.getStringCellValue();
                if(j == 0){
                    subject.setName(cellValue);
                }else if(j == 1){
                    subject.setLevel(Integer.parseInt(cellValue));
                }else if(j == 2){
                    subject.setLevelName(cellValue);
                }else if(j == 3){
                    subject.setDeleted(Boolean.parseBoolean(cellValue));
                }else if(j == 4){
                    subject.setItemOrder(Integer.parseInt(cellValue));
                }
                System.out.print(cellValue+"  ");
            }
            subjectCollection.add(subject);
//            System.out.println();
        }
        wb.close();
        fileInput.close();
        return subjectCollection;
    }

    public static Collection<Subject> ReadExcel(MultipartFile file, int rowBegin) throws IOException {
        InputStream fileInput = file.getInputStream();
        XSSFWorkbook wb = new XSSFWorkbook(fileInput);//由输入流文件得到工作簿对象
        //System.out.println("xssfWorkbook对象：" + wb);

        XSSFSheet sheet = wb.getSheetAt(0);//获取第一个sheet
        int lastRowNum = sheet.getLastRowNum(); //获取表格内容的最后一行的行数

        Collection<Subject> subjectCollection = new ArrayList<>();
        Subject subject = null;

        //rowBegin代表要开始读取的行号，下面这个循环的作用是读取每一行内容
        for (int i = rowBegin; i <= lastRowNum; ++i) {
            XSSFRow row = sheet.getRow(i);//获取每一行
            int columnNum = row.getLastCellNum();//获取每一行的最后一列的列号，即总列数
            subject = new Subject();
            for (int j=0; j<columnNum; ++j) {
                XSSFCell cell = row.getCell(j);//获取每个单元格
                //设置单元格类型
                if(cell == null){
//                    System.out.print("  ");
                    continue;
                }
                cell.setCellType(CellType.STRING);
                //获取单元格数据
                String cellValue = cell.getStringCellValue();
                if(j == 0){
                    subject.setName(cellValue);
                }else if(j == 1){
                    subject.setLevel(Integer.parseInt(cellValue));
                }else if(j == 2){
                    subject.setLevelName(cellValue);
                }else if(j == 3){
                    subject.setDeleted(Boolean.parseBoolean(cellValue));
                }else if(j == 4){
                    subject.setItemOrder(Integer.parseInt(cellValue));
                }
                System.out.print(cellValue+"  ");
            }
            subjectCollection.add(subject);
//            System.out.println();
        }
        wb.close();
        fileInput.close();
        return subjectCollection;
    }

    //写入excel
    public static void WriteExcel() throws IOException {
        //在内存中创建一个Excel文件
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建工作表，指定工作表名称
        XSSFSheet sheet = workbook.createSheet("写入测试");

        //创建行，0表示第一行
        XSSFRow row = sheet.createRow(0);
        //创建单元格，0表示第一个单元格
        row.createCell(0).setCellValue("编号");
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue("年龄");

        XSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("1");
        row1.createCell(1).setCellValue("小明");
        row1.createCell(2).setCellValue("10");

        XSSFRow row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("2");
        row2.createCell(1).setCellValue("小王");
        row2.createCell(2).setCellValue("20");

        //通过输出流将workbook对象下载到磁盘
        FileOutputStream out = new
                FileOutputStream("E:\\毕设\\ycx\\ExamSys\\src\\main\\java\\com\\ycx\\Exam\\file\\管理员题目导入模板.xlsx");
        workbook.write(out);
        out.flush();//刷新
        out.close();//关闭
        workbook.close();

    }
}
