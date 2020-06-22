package com.example.CrudWithAllDBRelationship.config;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanConfig implements AttributeConverter<Boolean, String> {
    //underline will appear on the class name above
    //hover then ALT + Enter then select implement override methods
    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {
        if (aBoolean == null){
            return null;
        }
        if (aBoolean.booleanValue()){
            return "Y";
        }
        return "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String s) {
        if (s == null){
            return null;
        }
        if (s.equals("Y") || s.equals("y")){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
