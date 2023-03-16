package com.ycx.Exam.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycx.Exam.entity.TextContent;
import com.ycx.Exam.mapper.TextContentMapper;
import com.ycx.Exam.service.TextContentService;
import org.springframework.stereotype.Service;

/**
 * @Author：ycx
 * @Date：2023/2/20 8:50
 * @Filename：TextContentServiceImpl
 */
@Service
public class TextContentServiceImpl extends ServiceImpl<TextContentMapper, TextContent> implements TextContentService {
}
