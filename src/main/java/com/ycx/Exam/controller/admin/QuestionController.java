package com.ycx.Exam.controller.admin;

import com.ycx.Exam.common.R;
import com.ycx.Exam.dto.QuestionPageRequestDto;
import com.ycx.Exam.entity.Question;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping("/page")
    public R<Question> page(@RequestBody QuestionPageRequestDto questionPageRequestDto){


        return R.error("");
    }
}
