package com.project.to.learn.projectToLearn.until;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.project.to.learn.projectToLearn.domain.ResponseServer;

import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class FormatResponseServer implements ResponseBodyAdvice{

  @Override
  public Object beforeBodyWrite(
    Object body, 
    MethodParameter returnType, 
    MediaType selectedContentType, 
    Class selectedConvertType, 
    ServerHttpRequest request,
      ServerHttpResponse response) {
        HttpServletResponse servletResponse = ((ServletServerHttpResponse) response).getServletResponse();
        int status = servletResponse.getStatus();

    ResponseServer<Object> res = new ResponseServer<Object>();
    res.setStatusCode(status);
    //error
    if(status >= 400){
      // res.setError(body.toString());
      // res.setMessage("Failed from FormatResponseService class");
      return body;
    }
    else{
      //success
      res.setData(body);
      res.setMessage("Successful from FormatResponseService class");
    }

    
    return res;
  }

  @Override
  public boolean supports(MethodParameter returnType, 
  Class converterType) {
    // whichever response have to Override
    // if return true, run beforeBodyWrite
    return true;
  }
  
}
