package com.scm.validator;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FileValidator implements ConstraintValidator<ValidFile, MultipartFile> {
//size
    private static final long  MAX_FILE_SIZE = 1024*1024*2;
//height
//width

    @Override
    public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
 
        if(value == null || value.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("upload file please ").addConstraintViolation();
            return false;
        }

        if(value.getSize() > MAX_FILE_SIZE){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("file exceeds file size").addConstraintViolation();
            return false;
        }  
   return true;
      

        }


    }
    

