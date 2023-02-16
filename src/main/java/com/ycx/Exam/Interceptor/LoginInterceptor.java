package com.ycx.Exam.Interceptor;

import com.ycx.Exam.common.BaseContext;
import com.ycx.Exam.utils.getTokenUtil;
import com.ycx.Exam.utils.jwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    //前置拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 拦截处理
        // 判断请求头里面是否携带token,如果没有携带返回没有用户的错误
        String token = getTokenUtil.getToken(request);

        Map<String, Object> map1 = jwtUtil.decodeJWT(token);
        Long userNo = (Long)map1.get("userNo");
        if(!request.getSession().getAttribute(userNo.toString()).equals(token)){
            return false;
        }
        BaseContext.setCurrentNo(userNo);

//        //2.2 判断redis中是否可以获取U-TOKEN A-TOKEN，如果获取不到没有用户的错误
//        String user = RedisUtils.INSTANCE.get(uToken);
//        //登录的用户已经过期了
//        if( StringUtils.isBlank(user)){
//            writeNoUserError(response,"expireUser");
//            return false;
//        }
//        //如果没有过期，刷新一下过期时间
//        //2.2.1 刷新session过期-redis里面的一个值
//        RedisUtils.INSTANCE.set(uToken,user,30*60);
        return true;
    }

    /**
     *  {"success":false,"message":"noUser"}
     * response.getWriter().write("{'success':false,messge:noUser}");
     * @param response
     */
//    private void writeNoUserError(HttpServletResponse response,String message) {
//        PrintWriter writer = null;
//        try {
//            response.setCharacterEncoding("utf-8"); //返回编码格式
//            response.setContentType("application/json; charset=utf-8"); // json方式放回
//            writer = response.getWriter();
//            writer.write("{\"success\":false,\"message\":"+"\""+message+"\""+"}");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if (writer != null) {
//                writer.close();
//            }
//        }
//    }

}
