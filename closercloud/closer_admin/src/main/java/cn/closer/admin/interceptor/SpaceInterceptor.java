package cn.closer.admin.interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName SpaceInterceptor.java
 * @Description TODO
 * @createTime 2020年03月10日 11:20:00
 */
@Component
public class SpaceInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil ;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        System.out.println("开始拦截.........");

        String header = request.getHeader("Authorization");
        System.out.println(header);
        if(header!=null && !"".equals(header)){

            if (header.startsWith("cat")){
                //得到token
                String token = header.substring(3);
                System.out.println("token:"+token);
                try {
                    //解析token
                    Claims claims = jwtUtil.parseJWT(token);
                    String id = claims.getId();
                    //存放到request域
                    request.setAttribute("user_id",id);
                }catch (Exception e) {

                    throw new RuntimeException("token错误");
                }
            }


        }


        return true;
    }
}
