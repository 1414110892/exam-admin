package com.ycx.Exam.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ycx.Exam.dto.QuestionPageRequestDto;
import com.ycx.Exam.entity.Question;

/**
 * @Author：ycx
 * @Date：2023/2/19 22:53
 * @Filename：QuestionService
 */
public interface QuestionService extends IService<Question> {

    Page QuestionPage(QuestionPageRequestDto questionPageRequestDto);
}
