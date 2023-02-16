package com.ycx.Exam.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class jwtUtil {
    private static final String SIGN="123456"; //密钥
    //1.通过jwt生成token字符串。
    public static String createToken(Map<String,Object> params){

        Map<String,Object> head=new HashMap<>();
        head.put("alg","HS256");
        head.put("typ","JWT");

        //定义颁发时间
        Date iss=new Date();
        //过期时间
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,30);
        Date expire = nowTime.getTime();

        String token = JWT.create()
                //指定头信息
                .withHeader(head)
                //载荷种的过期时间
                .withExpiresAt(expire)
                //颁发时间
                .withIssuedAt(iss)
                //颁发人
                .withIssuer("ycx")
                //自定义的载荷内容
                .withClaim("userInfo",params)
                //签名
                .sign(Algorithm.HMAC256(SIGN));

        return token;
    }

    //2. 判断token是否合法
    public static boolean verifyToken(String token){
        JWTVerifier build = JWT.require(Algorithm.HMAC256(SIGN)).build();
        try {
            DecodedJWT verify = build.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //3. 解析token种的内容
    public static Map<String,Object> decodeJWT(String token){
        Map<String, Object> userInfo = JWT.decode(token).getClaim("userInfo").asMap();
        return userInfo;
    }
}
