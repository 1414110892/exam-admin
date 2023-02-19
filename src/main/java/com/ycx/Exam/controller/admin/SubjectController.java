package com.ycx.Exam.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ycx.Exam.common.R;
import com.ycx.Exam.entity.Subject;
import com.ycx.Exam.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    //分页模糊查询学科
    @GetMapping("/list")
    public R<Page> page(int page, int limit, String userSearch){

        //分页模糊查询学生信息
        Page<Subject> page1 = new Page<>(page,limit);
        LambdaQueryWrapper<Subject> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(userSearch != "",Subject::getLevel,userSearch);
        subjectService.page(page1,lambdaQueryWrapper);

        return R.success(page1);
    }

    //修改学科
    @PutMapping("/update")
    public R<String> update(@RequestBody Subject subject){

        subjectService.subjectUpdate(subject);
        return R.success("修改成功");
    }

    //删除学科
    @DeleteMapping("/delete/{id}")
    public R<String> delete(@PathVariable Long id){

        subjectService.removeById(id);
        return R.success("删除成功");
    }

    //添加学科
    @PostMapping("/add")
    public R<String> save(@RequestBody Subject subject){

        subjectService.subjectSave(subject);

        return R.success("插入成功");
    }

    //根据年级查到对应的学科
    @GetMapping("/findSubjectByLevel/{levelId}")
    public R<List<Subject>> findSubjectByLevel(@PathVariable int levelId){
        LambdaQueryWrapper<Subject> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Subject::getLevel,levelId);
        List<Subject> list = subjectService.list(lambdaQueryWrapper);
        return R.success(list);
    }
}
