package com.example.aichatbot.model;


import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Appointment {

    private Long id;


    private String customerName;

    private String customerPhone;

    private String serviceType;

    private LocalDateTime appointmentTime;

    private Integer status;

    private LocalDateTime createTime;

    // 插入前自动填充创建时间
    public void prePersist() {
        this.createTime = LocalDateTime.now();
    }

    // Getter + Setter（Lombok 的 @Data 注解可简化）
}