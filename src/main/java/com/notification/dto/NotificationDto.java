package com.notification.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NotificationDto {

    private String serviceName;

    private String reasonOfFailure;

    private Boolean isSuccess;

    //Request/Response from other service
//    private String message;

    private OrderResponseDto masterDto;

}
