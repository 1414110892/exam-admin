package com.ycx.Exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ycx.Exam.entity.Subject;

import java.util.Collection;

public interface SubjectService extends IService<Subject> {

    Boolean subjectUpdate(Subject subject);

    Boolean subjectAddBatch(Collection<Subject> subjectCollection);

    Boolean subjectSave(Subject subject);
}
