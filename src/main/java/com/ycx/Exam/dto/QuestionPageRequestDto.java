package com.ycx.Exam.dto;

import com.ycx.Exam.common.BasePage;
import lombok.Data;

/**
 * @Author：ycx
 * @Date：2023/2/19 18:53
 * @Filename：QuestionPageRequestDto
 */
@Data
public class QuestionPageRequestDto extends BasePage {
    private Integer level;
    private Long subject;
    private Integer questionType;
}
