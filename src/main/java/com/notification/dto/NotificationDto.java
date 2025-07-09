package com.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class NotificationDto {

    private String serviceName;

    private String reasonOfFailure;

    private Boolean isSuccess;

    //Request/Response from other service
    private String message;

}
