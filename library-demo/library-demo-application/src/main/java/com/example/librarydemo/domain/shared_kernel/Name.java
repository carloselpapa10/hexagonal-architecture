package com.example.librarydemo.domain.shared_kernel;

import com.example.librarydemo.domain.shared_kernel.exception.NameMaxLengthException;
import com.example.librarydemo.domain.shared_kernel.exception.NameShouldNotBeEmptyException;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@NonFinal
public class Name {

    private final String value;

    public Name(String value) throws BusinessException {

        //non null business exception validation
        if(value.trim().isEmpty()){
            throw new NameShouldNotBeEmptyException();
        }

        //max length of characters business exception validation
        if(value.length() > 30){
            throw new NameMaxLengthException();
        }

        this.value = value;
    }
}
