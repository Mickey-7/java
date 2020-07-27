package com.example.ObjectMapperDemo.domain.mixin;

import com.example.ObjectMapperDemo.domain.Address;
import com.example.ObjectMapperDemo.domain.Hobby;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public abstract class StudentIgnoreMixin {
    @JsonIgnore
    public abstract String getPassword();

    @JsonIgnore
    public abstract List<Address> getAddress();

    @JsonIgnore
    public abstract List<Hobby> getHobbies();
}
