package com.joker.ams.filter;

import com.joker.ams.common.LoginUser;
import com.joker.ams.utils.JwtUtil;
import com.joker.ams.utils.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    RedisCache redisCache;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            //让后面的过滤器去执行
            filterChain.doFilter(request, response);
            return;
        }
        String userID;
        //解析token
        //获取userID
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userID= claims.getSubject();
        } catch (Exception e) {
            throw new RuntimeException("token过期或不合法！");
        }
        //获取
        LoginUser user = redisCache.getCacheObject("login:"+userID);
        if (Objects.isNull(user)){
            throw new RuntimeException("当前用户未登录");
        }
        //封装Authentication
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        //存入SecurityContextHolder
        filterChain.doFilter(request, response);
    }
}
