package com.lxh.fushoujia.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: fushoujia
 * @description: 用于token的生成和验证
 * @author: Mr.Wang
 * @create: 2019-10-11 15:31
 **/

public class JwtUtil {

    /*过期时间*/
    private static final long expireTime = 80 * 60 * 1000;

    //Token秘钥
    private static final String TOKEN_SECRET = "ssccaa1236900";

    /*
    * userName: 用户名称
    * userId: 用户Id
    * 生成含有用户信息的token
    * */
    public static String sign (String userName, int userId) {
         try {
             //过期时间
             Date date = new Date(System.currentTimeMillis() + expireTime);
             //秘钥及加密算法
             Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
             //设置头部信息
             Map<String, Object> header = new HashMap<>();
             header.put("typ", "JWT");
             header.put("alg", "HS256");

             return JWT.create()
                     .withHeader(header)
                     .withClaim("userName", userName)
                     .withClaim("userId", userId)
                     .withExpiresAt(date)//过期时间
                     .sign(algorithm);//加密

         } catch (IOException i) {
             i.printStackTrace();
             return null;
         }
    }
    /*
    * return token是否正确
    * 验证token是否是正确
    * */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier jv = JWT.require(algorithm).build();
            DecodedJWT jwt = jv.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /*
    * 获取token中的token用户名信息
    * */
    public static String getUserName(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userName").asString();
        } catch (Exception e) {
            return null;
        }
    }

    /*
    * 获取token中的用户Id信息
    * */
    public static int getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asInt();
        } catch (Exception e) {
            return 0;
        }
    }

}
