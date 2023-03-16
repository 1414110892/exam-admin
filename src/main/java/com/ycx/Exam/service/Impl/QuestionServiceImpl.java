package com.ycx.Exam.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycx.Exam.dto.QuestionPageRequestDto;
import com.ycx.Exam.entity.Question;
import com.ycx.Exam.entity.Subject;
import com.ycx.Exam.entity.TextContent;
import com.ycx.Exam.mapper.QuestionMapper;
import com.ycx.Exam.service.QuestionService;
import com.ycx.Exam.service.SubjectService;
import com.ycx.Exam.service.TextContentService;
import com.ycx.Exam.vo.QuestionPageResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author：ycx
 * @Date：2023/2/19 22:53
 * @Filename：QuestionServiceImpl
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

    @Autowired
    private TextContentService textContentService;

    @Autowired
    private SubjectService subjectService;

    @Override
    public Page QuestionPage(QuestionPageRequestDto questionPageRequestDto) {
        int limit = questionPageRequestDto.getLimit();
        int page = questionPageRequestDto.getPage();
        //分页查询
        Page<Question> page1 = new Page<>(page,limit);
        Page<QuestionPageResponseVo> page2 = new Page<>();

        LambdaQueryWrapper<Question> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //条件查询
        lambdaQueryWrapper.eq(questionPageRequestDto.getQuestionType()!=null
                ,Question::getQuestionType
                ,questionPageRequestDto.getQuestionType());
        lambdaQueryWrapper.eq(questionPageRequestDto.getLevel()!=null
                ,Question::getGradeLevel
                ,questionPageRequestDto.getLevel());

        //分页条件查询查询Question
        this.page(page1, lambdaQueryWrapper);

        BeanUtils.copyProperties(page1,page2,"records");

        List<Question> records = page1.getRecords();

        //判断前端是否传来了学科id，有就提前过滤
        if(questionPageRequestDto.getSubject() != null){
            List<QuestionPageResponseVo> list = records.stream().filter(item -> item.getSubjectId() == questionPageRequestDto.getSubject()).map((item)->{

                QuestionPageResponseVo qpv = new QuestionPageResponseVo();
                Long infoTextContentId = item.getInfoTextContentId();
                Long subjectId = item.getSubjectId();

                BeanUtils.copyProperties(item,qpv);

                TextContent textContent = textContentService.getById(infoTextContentId);
                Subject subject = subjectService.getById(subjectId);


                if(textContent!=null && subject!=null){
                    //题干和解析
                    String title = textContent.getTitle();
                    String analysis = textContent.getAnalysis();
                    qpv.setTitle(title);
                    qpv.setAnalysis(analysis);
                    //学科名称
                    String name = subject.getName();
                    qpv.setName(name);
                }

                return qpv;
            }).collect(Collectors.toList());

            page2.setRecords(list);
        }else{
            List<QuestionPageResponseVo> list = records.stream().map((item)->{

                QuestionPageResponseVo qpv = new QuestionPageResponseVo();
                Long infoTextContentId = item.getInfoTextContentId();
                Long subjectId = item.getSubjectId();

                BeanUtils.copyProperties(item,qpv);

                TextContent textContent = textContentService.getById(infoTextContentId);
                Subject subject = subjectService.getById(subjectId);


                if(textContent!=null && subject!=null){
                    //题干和解析
                    String title = textContent.getTitle();
                    String analysis = textContent.getAnalysis();
                    qpv.setTitle(title);
                    qpv.setAnalysis(analysis);
                    //学科名称
                    String name = subject.getName();
                    qpv.setName(name);
                }

                return qpv;
            }).collect(Collectors.toList());

            page2.setRecords(list);
        }

        return page2;
    }
}
