package com.booking.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "Users")
public class Users{
    @Id
    private String id;
    private String name;
    private String city;
    private String address;

    private String password;

    private String username;

    private String phone;

}
