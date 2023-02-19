package com.ycx.Exam.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycx.Exam.Exception.SubjectException;
import com.ycx.Exam.entity.Subject;
import com.ycx.Exam.mapper.SubjectMapper;
import com.ycx.Exam.service.SubjectService;
import com.ycx.Exam.utils.judgeLevel;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {
    @Override
    public Boolean subjectUpdate(Subject subject) {
        Integer level = judgeLevel.getLevelName(subject.getLevelName());
        subject.setLevel(level);
        Subject byId = this.getById(subject);
        if(byId.getName().equals(subject.getName()) && byId.getLevelName().equals(subject.getLevelName()) && byId.getLevel().equals(subject.getLevel())){
            throw new SubjectException("该年级的学科已创建");
        }
        boolean b = this.updateById(subject);
        if(!b){
            throw new SubjectException("修改失败");
        }
        return true;
    }

    @Override
    public Boolean subjectAddBatch(Collection<Subject> subjectCollection) {

        this.saveBatch(subjectCollection);
        return true;
    }

    @Override
    public Boolean subjectSave(Subject subject) {
        Integer levelName = judgeLevel.getLevelName(subject.getLevelName());
        subject.setLevel(levelName);
        boolean save = this.save(subject);
        if(!save){
            throw new SubjectException("添加失败");
        }
        return true;
    }


}
