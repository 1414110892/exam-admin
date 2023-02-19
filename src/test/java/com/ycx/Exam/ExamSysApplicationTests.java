package com.ycx.Exam;

import com.ycx.Exam.poi.createExcel;
import com.ycx.Exam.poi.createExcelXSSF;
import com.ycx.Exam.utils.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ExamSysApplicationTests {

    @Test
    void contextLoads() {

        String md5 = MD5Util.getMD5("123456");
        System.out.println(md5);
    }

    @Test
    void CreatExcel(){
        try {
            createExcel.createExcel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void parseExcel(){
        String filePath = "E:\\毕设\\ycx\\ExamSys\\src\\main\\java\\com\\ycx\\Exam\\file\\11.xlsx";
        try {
            createExcelXSSF.ReadExcel(filePath,0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
