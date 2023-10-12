package com.example.app.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PostRequest {
    private String content;

    private byte[] postimg;

    private LocalDateTime datetime;

    private BigDecimal latitude;

    private BigDecimal longtitude;

    private int userid;
}
