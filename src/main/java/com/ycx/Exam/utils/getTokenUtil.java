package com.ycx.Exam.utils;

import javax.servlet.http.HttpServletRequest;

public class getTokenUtil {

    public static String getToken(HttpServletRequest request){
        String cookie = request.getHeader("Cookie");
        StringBuffer token = new StringBuffer();
        String[] split = cookie.split("; ");
        for (String s : split) {
            if(s.contains("vue_admin_template_token=")){
                String[] split1 = s.split("=");
                token = new StringBuffer(split1[1]);
                System.out.println(token);
                break;
            }
        }
        return token.toString();
    }
}
