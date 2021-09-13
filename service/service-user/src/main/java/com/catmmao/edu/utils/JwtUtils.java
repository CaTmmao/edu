package com.catmmao.edu.utils;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// JWT 配置
public class JwtUtils {

    // token过期时间
    public static final long EXPIRE = 1000 * 60 * 60 * 24;
    // 秘钥（配合加密）
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";

    /**
     * 生成 token 字符串
     *
     * @param id       用户ID
     * @param nickname 用户名
     * @return 生成的 token
     */
    public static String generateToken(String id, String nickname) {

        return Jwts.builder()
                // 设置 JWT 头信息
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")

                // 设置过期时间
                .setSubject("edu-user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))

                // 设置 token 主体部分（可存储用户信息）
                .claim("id", id)
                .claim("nickname", nickname)

                // 签名哈希（根据秘钥和xx方式用来编码生成token）
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
    }

    /**
     * 判断 token 是否有效
     *
     * @param token token
     * @return 是否有效
     */
    public static boolean checkToken(String token) {

        if (token.isEmpty()) {
            return false;
        }

        try {

            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * 判断 token 是否有效
     *
     * @param request http请求对象
     * @return 是否有效
     */
    public static boolean checkToken(HttpServletRequest request) {

        String token = request.getHeader("token");
        return checkToken(token);
    }

    /**
     * 根据 token 获取用户ID
     *
     * @param request http请求对象
     * @return 用户ID
     */
    public static String getMemberIdByJwtToken(HttpServletRequest request) {

        String token = request.getHeader("token");
        if (token.isEmpty()) {

            return "";
        }

        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        // 获取主体信息
        Claims claims = claimsJws.getBody();
        return (String) claims.get("id");
    }
}