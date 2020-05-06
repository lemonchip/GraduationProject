package cn.closer.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName JwtTest.java
 * @Description TODO
 * @createTime 2020年03月09日 16:06:00
 */
public class JwtTest {

    public static void main(String[] args) {
        JwtBuilder jwtBuilder = Jwts.builder() ;
            jwtBuilder.setId("666")
                      .setSubject("haha")
                      .setIssuedAt(new Date())
                      .signWith(SignatureAlgorithm.HS256,"closer")
                      .setExpiration(new Date(new Date().getTime()+1000*60*60*24*7));
                      System.out.println(jwtBuilder.compact());

      Claims claims = Jwts.parser()
                    .setSigningKey("closer")
                    .parseClaimsJws(jwtBuilder.compact())
                    .getBody();
        System.out.println("用户名"+claims.getSubject());
        System.out.println("用户名"+claims.getId());
        System.out.println("登录时间"+claims.getIssuedAt());
        System.out.println("过期时间"+claims.getExpiration());





    }
}
