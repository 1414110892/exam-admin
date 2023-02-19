package com.ycx.Exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ycx.Exam.entity.Question;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author：ycx
 * @Date：2023/2/19 22:52
 * @Filename：QuestionMapper
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {
}
