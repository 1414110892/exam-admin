package com.ycx.Exam.controller.admin;

import com.ycx.Exam.common.R;
import com.ycx.Exam.entity.Subject;
import com.ycx.Exam.service.SubjectService;
import com.ycx.Exam.utils.poiUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

@Slf4j
@RestController
@RequestMapping("/excel")
public class downloadExcelController {

    @Autowired
    private SubjectService subjectService;

    private String basePath = "E:\\毕设\\ycx\\ExamSys\\src\\main\\java\\com\\ycx\\Exam\\file\\";
    @GetMapping("/downloadExcel")
    public void download(HttpServletResponse response)throws Exception{
        //1.设置响应类型
        response.setContentType("application/octet-stream;charset=UTF-8");
        //2.获取输出流
        OutputStream out=response.getOutputStream();

        //浏览器接收到响应信息之后，默认情况下，直接在显示窗口中打开响应信息；即使打不开，也会调用应用程序打开；只有实在打不开，才会激活文件下载窗口。
        //可以设置响应头信息，使浏览器接收到响应信息之后，直接激活文件下载窗口，即使能打开也不打开
        response.addHeader("Content-Disposition","attachment;filename=mystudentList.xls");

        //读取excel文件(InputStream)，把输出到浏览器(OutoutStream)
        InputStream is=new FileInputStream("E:\\毕设\\ycx\\ExamSys\\src\\main\\java\\com\\ycx\\Exam\\file\\管理员题目导入模板.xlsx");
        byte[] buff=new byte[256];
        int len=0;
        while((len=is.read(buff))!=-1){
            out.write(buff,0,len);
        }

        //关闭资源
        is.close();
        out.flush();
    }

    @PostMapping("/uploadExcel")
    public R<String> upload(MultipartFile file){
        try {

            Collection<Subject> subjectCollection = poiUtil.ReadExcel(file, 1);
            subjectService.subjectAddBatch(subjectCollection);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success("导入成功");
    }
}
