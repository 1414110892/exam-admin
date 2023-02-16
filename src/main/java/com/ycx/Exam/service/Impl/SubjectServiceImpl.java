package com.ycx.Exam.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycx.Exam.entity.Subject;
import com.ycx.Exam.mapper.SubjectMapper;
import com.ycx.Exam.service.SubjectService;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {
}
