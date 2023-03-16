package com.ycx.Exam.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycx.Exam.entity.TextItem;
import com.ycx.Exam.mapper.TextItemMapper;
import com.ycx.Exam.service.TextItemService;
import org.springframework.stereotype.Service;

/**
 * @Author：ycx
 * @Date：2023/2/20 8:53
 * @Filename：TextItemServiceImpl
 */
@Service
public class TextItemServiceImpl extends ServiceImpl<TextItemMapper, TextItem> implements TextItemService {
}
