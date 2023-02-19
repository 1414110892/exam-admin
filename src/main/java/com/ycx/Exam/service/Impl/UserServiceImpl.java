package com.ycx.Exam.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycx.Exam.Exception.UserException;
import com.ycx.Exam.common.R;
import com.ycx.Exam.entity.User;
import com.ycx.Exam.mapper.UserMapper;
import com.ycx.Exam.service.UserService;
import com.ycx.Exam.utils.MD5Util;
import com.ycx.Exam.utils.getTokenUtil;
import com.ycx.Exam.utils.jwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public String userLogin(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUserNo,user.getUserNo());
        User one = this.getOne(lambdaQueryWrapper);
        if(one == null){
            throw new UserException("该用户不存在");
        }
        if(!one.getPassword().equals(MD5Util.getMD5(user.getPassword())) ){
            System.out.println("加密后密码"+MD5Util.getMD5(user.getPassword()));
            throw new UserException("密码错误");
        }

        if(one.getStatus() == 1){
            throw new UserException("该账号已被禁用");
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("userNo",user.getUserNo());
        map.put("password",user.getPassword());
        String token = jwtUtil.createToken(map);
        return token;
    }

    @Override
    public R<User> userInfo(HttpServletRequest request) {
        boolean tokenIsTure = false;
        String token = getTokenUtil.getToken(request);

        tokenIsTure = jwtUtil.verifyToken(token);

        //解密出账号密码
        Map<String, Object> map = new HashMap<>();

//        System.out.println("11111111111111111111111111111");
        if(tokenIsTure){
            map = jwtUtil.decodeJWT(token);
            Long userNo = (Long) map.get("userNo");
            LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(User::getUserNo,userNo);
            User one = this.getOne(lambdaQueryWrapper);
            System.out.println(one.getPassword());
            one.setPassword("");
            System.out.println(one.getPassword());

            return R.success(one);
        }
//        System.out.println("22222222222222222222222222222222");
        throw new UserException("token过期");
    }

    @Override
    public Boolean userSave(User user) {

        String md5Pwd = MD5Util.getMD5(user.getPassword());
        user.setPassword(md5Pwd);

        user.setRole(1);
        boolean save = this.save(user);
        if(!save){
            throw new UserException("插入失败");
        }
        return true;
    }

    @Override
    public Boolean userUpdate(User user) {

        String md5Pwd = MD5Util.getMD5(user.getPassword());
        user.setPassword(md5Pwd);

        boolean update = this.updateById(user);
        if(!update){
            throw new UserException("修改失败");
        }
        return true;
    }

    @Override
    public Boolean userEditStatus(Long id) {
        User user = this.getById(id);
        int status = user.getStatus();
        if(status == 0){
            user.setStatus(1);
        }else{
            user.setStatus(0);
        }
        boolean b = this.updateById(user);
        if(!b){
            throw new UserException("修改失败");
        }
        return true;
    }
}
