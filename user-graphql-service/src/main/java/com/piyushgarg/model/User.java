package com.piyushgarg.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Data
@Table
public class User {

    @PrimaryKey
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String avatar;
    private String role;
    
}
