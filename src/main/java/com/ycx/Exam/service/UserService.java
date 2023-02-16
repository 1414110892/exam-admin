package com.ycx.Exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ycx.Exam.common.R;
import com.ycx.Exam.entity.User;

import javax.servlet.http.HttpServletRequest;


public interface UserService extends IService<User> {

    String userLogin(User user);

    R<User> userInfo(HttpServletRequest request);

    Boolean userSave(User user);

    Boolean userUpdate(User user);
}
