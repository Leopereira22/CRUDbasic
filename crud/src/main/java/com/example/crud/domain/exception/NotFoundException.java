package com.example.crud.domain.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class NotFoundException extends Exception{

   public NotFoundException(String msg){
       super(msg);
   }
}
