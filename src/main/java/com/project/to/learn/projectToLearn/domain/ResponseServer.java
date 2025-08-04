package com.project.to.learn.projectToLearn.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseServer<T> {
  private String error;
  private long statusCode;
  private Object message;
  private T data;
  
}
