package com.ycx.Exam.vo;

import com.ycx.Exam.entity.Question;
import com.ycx.Exam.entity.TextContent;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：ycx
 * @Date：2023/2/19 21:01
 * @Filename：questionPageResponseVo
 */
@Data
public class QuestionPageResponseVo extends Question{

    //该题目对应的题目解析等
    private List<TextContent> textContents = new ArrayList<>();

    //题干
    private String title;

    //解析
    private String analysis;

    //学科名称
    private String name;


}
