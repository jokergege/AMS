package com.joker.ams.handler;

import com.alibaba.fastjson.JSON;
import com.joker.ams.common.ResultVo;
import com.joker.ams.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        //给前端resultVo 的JSON数据
        ResultVo resultVo = new ResultVo(HttpStatus.FORBIDDEN.value(), "你没有权限哦！");
        String s = JSON.toJSONString(resultVo);
        WebUtils.renderString(response,s);
    }
}
