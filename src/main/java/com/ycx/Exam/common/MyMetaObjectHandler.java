package com.ycx.Exam.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入操作 自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("公共字段自动填充[insert]...");
        log.info(metaObject.toString());
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("modifyTime", LocalDateTime.now());

        metaObject.setValue("createUser", BaseContext.getCurrentNo());
        metaObject.setValue("updateUser", BaseContext.getCurrentNo());
    }

    /**
     * 更新操作自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
//        long id = Thread.currentThread().getId();
//        log.info("线程id{}",id);
        log.info("公共字段自动填充[update]...");
        log.info(metaObject.toString());
        metaObject.setValue("modifyTime", LocalDateTime.now());
//        metaObject.setValue("updateUser", BaseContext.getCurrentId());
    }
}
