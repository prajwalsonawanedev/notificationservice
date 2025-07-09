package com.notification.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequestDto {

    private Long orderId;

    private String userId;

    private String stockId;

    private Integer quantity;

    private Double price;

    private Double totalAmount;

    private String status;
}