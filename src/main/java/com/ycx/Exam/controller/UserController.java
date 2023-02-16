package com.ycx.Exam.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ycx.Exam.common.R;
import com.ycx.Exam.entity.User;
import com.ycx.Exam.service.UserService;
import com.ycx.Exam.utils.getTokenUtil;
import com.ycx.Exam.utils.jwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public R<String> login(@RequestBody User user,HttpServletRequest request){

        String token = userService.userLogin(user);
        //将token保存在session中
        request.getSession().setAttribute(user.getUserNo().toString(),token);
        return R.success(token);
    }
    @GetMapping("/info")
    public R<User> info(HttpServletRequest request){

        R<User> userR = userService.userInfo(request);

        return userR;

    }

    /**
     * 退出
     * @return
     */
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request){

        //移除掉session中当前用户的token
        String token = getTokenUtil.getToken(request);
        Map<String, Object> map = jwtUtil.decodeJWT(token);
        String userNo = (String)map.get("userNo");
        request.getSession().removeAttribute(userNo);
        return R.success("success");
    }

    @GetMapping("/list")
    public R<Page> page(int page,int limit,String userSearch){

        //分页模糊查询学生信息
        Page<User> page1 = new Page<>(page,limit);
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(userSearch != "",User::getUserNo,userSearch);
        lambdaQueryWrapper.eq(User::getRole,1);
        lambdaQueryWrapper.orderByDesc(User::getModifyTime);

        userService.page(page1,lambdaQueryWrapper);
        List<User> records = page1.getRecords();
        for (User record : records) {
            record.setPassword("");
        }
        return R.success(page1);
    }

    @PostMapping("/add")
    public R<String> save(@RequestBody User user){

        userService.userSave(user);
        return R.success("插入成功");
    }

    @PutMapping("/update")
    public R<String> update(@RequestBody User user){
        System.out.println(user.getId());
        userService.userUpdate(user);
        return R.success("修改成功");
    }
}
