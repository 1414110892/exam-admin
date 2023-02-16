package com.ycx.Exam.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ycx.Exam.common.R;
import com.ycx.Exam.entity.Subject;
import com.ycx.Exam.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/list")
    public R<Page> page(int page, int limit, String userSearch){

        //分页模糊查询学生信息
        Page<Subject> page1 = new Page<>(page,limit);
        LambdaQueryWrapper<Subject> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(userSearch != "",Subject::getLevel,userSearch);
        subjectService.page(page1,lambdaQueryWrapper);

        return R.success(page1);
    }

}
