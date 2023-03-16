package com.ycx.Exam.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ycx.Exam.common.R;
import com.ycx.Exam.dto.QuestionPageRequestDto;
import com.ycx.Exam.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：ycx
 * @Date：2023/2/19 14:44
 * @Filename：QuestionController
 */
@Slf4j
@RestController
@RequestMapping("/exam/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    /**
     * 试卷分页模糊查询
     * @param questionPageRequestDto
     * @return
     */
    @PostMapping("/page")
    public R<Page> page(@RequestBody QuestionPageRequestDto questionPageRequestDto){

        Page page = questionService.QuestionPage(questionPageRequestDto);

        return R.success(page);
    }
}
