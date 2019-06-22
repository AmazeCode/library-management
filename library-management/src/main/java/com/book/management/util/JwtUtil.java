package com.book.management.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * JWT工具类
 */
public class JwtUtil {

    //签发者
    public static final String ISSUER = "book";

    //公钥
    public static final String SECRET = "management";

    /**
     * 生成Token
     * @param user
     * @return
     */
    /*public static String createToken(User user) {
        // 签发时间
        Date iatDate = new Date();
        // 过期时间
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 120);
        Date expiresDate = nowTime.getTime();
        // header
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                .withHeader(map)
                .withIssuer(JwtUtil.ISSUER)
                .withAudience(Long.toString(user.getUserId()))//接收者
                .withExpiresAt(expiresDate)
                .withIssuedAt(iatDate)
                .sign(Algorithm.HMAC256(JwtUtil.SECRET));
        return token;
    }*/

    /**
     * 获取token中的用户Id
     * @param token
     * @return
     */
    public static String getUserId(String token) {
        String userId;
        DecodedJWT jwt = JWT.decode(token);
        userId = jwt.getAudience().get(0);
        return userId;
    }

    public static void main(String args[]) {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxIiwiaXNzIjoi6IKG5oSP44CCLSIsImV4cCI6MTU1MjQzNjIwMywiaWF0IjoxNTUyNDM0NDAzfQ.rtpYANOHZE_tpkF0ChWsLOHMrdmWETjg2SVX3wjr6OQ";
        System.out.println(JwtUtil.getUserId(token));
    }
}
