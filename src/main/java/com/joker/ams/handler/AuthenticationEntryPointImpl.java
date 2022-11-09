package com.joker.ams.handler;

import com.alibaba.fastjson.JSON;
import com.joker.ams.common.ResultVo;
import com.joker.ams.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    //异常处理
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //给前端resultVo 的JSON数据
        ResultVo resultVo = new ResultVo(HttpStatus.UNAUTHORIZED.value(), "登陆错误，请重新登陆");
        String s = JSON.toJSONString(resultVo);
        WebUtils.renderString(response,s);
    }
}
