package com.ycx.Exam.vo;

import com.ycx.Exam.entity.Question;
import com.ycx.Exam.entity.textContent;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：ycx
 * @Date：2023/2/19 21:01
 * @Filename：questionPageResponseVo
 */
public class questionPageResponseVo extends Question{

    //该题目对应的
    private List<textContent> textContents = new ArrayList<>();

}
