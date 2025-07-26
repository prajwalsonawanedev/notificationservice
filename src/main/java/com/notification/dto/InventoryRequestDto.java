package com.notification.dto;

import lombok.*;

@Builder
public class InventoryRequestDto implements MasterDto {

    private String userId;

    private String stockId;

    private Double totalAmount;

    private Integer quantity;

    private String status;
}