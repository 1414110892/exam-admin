package com.ycx.Exam.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycx.Exam.entity.Question;
import com.ycx.Exam.mapper.QuestionMapper;
import com.ycx.Exam.service.QuestionService;
import org.springframework.stereotype.Service;

/**
 * @Author：ycx
 * @Date：2023/2/19 22:53
 * @Filename：QuestionServiceImpl
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

}
