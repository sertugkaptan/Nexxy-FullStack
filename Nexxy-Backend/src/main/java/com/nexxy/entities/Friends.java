package com.nexxy.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Date;

public class Friends {

    @Id
    @GeneratedValue
    private String id;

    private User user1;
    private User user2;

    private Date createdAt;
}
