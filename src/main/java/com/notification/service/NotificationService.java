package com.notification.service;

import com.notification.dto.NotificationDto;

public interface NotificationService {

    void messageFromOrderService(NotificationDto notificationDto);

    void messageFromInventoryService(NotificationDto notificationDto);
}
