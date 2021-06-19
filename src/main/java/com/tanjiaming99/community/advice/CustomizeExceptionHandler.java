package com.tanjiaming99.community.advice;

import com.alibaba.fastjson.JSON;
import com.tanjiaming99.community.dto.ResultDTO;
import com.tanjiaming99.community.exception.CustomizeErrorCode;
import com.tanjiaming99.community.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author tanjiaming99.com
 * @Date 2021/6/18 15:41
 **/
@ControllerAdvice
public class CustomizeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    Object handle(HttpServletRequest request, HttpServletResponse response, Throwable ex, Model model){
        String contentType = request.getContentType();
        if ("application/json".equals(contentType)){
            ResultDTO resultDTO = null;
            // 返回JSON
            if(ex instanceof CustomizeException){
                resultDTO = ResultDTO.errorOf((CustomizeException) ex);
            }else{
                resultDTO = ResultDTO.errorOf(CustomizeErrorCode.SYSTEM_ERROR);
            }

            try {
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("UTF-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }else{
            if(ex instanceof CustomizeException){
                model.addAttribute("message", ex.getMessage());
            }else{
                model.addAttribute("message", CustomizeErrorCode.SYSTEM_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }
    }


}
