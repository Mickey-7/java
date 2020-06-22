package com.example.Java_Guides_Lombok.domain;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// to print objects
@ToString
//@ToString(exclude = "createdDateTime")
public class UserLombokModel {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private LocalDateTime createdDateTime;



}
