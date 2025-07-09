package com.notification.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryRequestDto {

    private String userId;

    private String stockId;

    private Double totalAmount;

    private Integer quantity;

    private String status;
}