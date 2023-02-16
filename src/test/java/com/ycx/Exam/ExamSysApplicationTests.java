package com.ycx.Exam;

import com.ycx.Exam.utils.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExamSysApplicationTests {

    @Test
    void contextLoads() {

        String md5 = MD5Util.getMD5("123456");
        System.out.println(md5);
    }

}
