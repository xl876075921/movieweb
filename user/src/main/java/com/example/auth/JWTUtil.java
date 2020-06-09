package com.example.auth;

import com.example.pojo.UserInfo;
import io.jsonwebtoken.*;
import org.joda.time.DateTime;

/**
 * @BelongsProject: mallproj
 * @BelongsPackage: com.wn.auth.util
 * @Author: 闫靖方
 * @CreateTime: 2020-05-14 11:5
 * @Description:
 */
public class JWTUtil {
    public static String generateToken(UserInfo user,Integer time,String rsaPath){
        String token = "";
        try{
            /*token = Jwts.builder()
                    .claim("id",user.getId()).claim("username",user.getUsername()).claim("role",user.getRole())
                    .setExpiration(DateTime.now().plusMinutes(time).toDate())
                    .signWith(SignatureAlgorithm.ES256,RsaUtils.getPrivateKey(rsaPath))
                    .compact();*/
            token = Jwts.builder()
                    .claim("id", user.getId()).claim("username",user.getName()).claim("role", user.getRole())
                    .setExpiration(DateTime.now().plusMinutes(time).toDate())
                    .signWith(SignatureAlgorithm.ES256, RsaUtils.getPrivateKey(rsaPath))
                    .compact();
        }catch (Exception e){
            System.out.println("token生成失败");
        }
        return token;
    }
    public static UserInfo ParseToken(String rsaPath,String token){
        /*User user = null;
        try{
            Jwt<Header, Claims> claimsJwt = Jwts.parser().setSigningKey(RsaUtils.getPublicKey(rsaPath)).parseClaimsJwt(token);
            Claims body = claimsJwt.getBody();
            int id = Integer.parseInt(body.get("id").toString());
            String username = body.get("username").toString();
            int role = Integer.parseInt(body.get("role").toString());
            user = new User(id, username, role);
        }catch(Exception e){
            System.out.println("token解析失败");
        }
        return user;*/
        UserInfo user = null;
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(RsaUtils.getPublicKey(rsaPath)).parseClaimsJws(token);
            Claims body = claimsJws.getBody();
            //从荷载中通过键获取数据
            int id = Integer.parseInt(body.get("id").toString());
            String username = body.get("name").toString();
            int role = Integer.parseInt(body.get("role").toString());

            user = new UserInfo(id, username, role);
        }catch (Exception e){
            System.out.println("token解析失败");
        }
        return user;

    }
}
