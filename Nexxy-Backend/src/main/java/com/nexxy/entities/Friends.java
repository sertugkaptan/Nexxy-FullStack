package com.nexxy.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Friends {

    @Id
    @GeneratedValue
    private String id;

    private Long user1;
    private Long user2;

    private Date createdAt;
}
