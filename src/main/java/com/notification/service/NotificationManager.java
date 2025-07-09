package com.notification.service;

import com.notification.dto.NotificationDto;

public interface NotificationManager {

    void handelOrderCreated(NotificationDto notificationDto);

    void handelOrderNotCreated(NotificationDto notificationDto);

    void handelInventoryNotCreated(NotificationDto notificationDto);

    void handelInventoryCreated(NotificationDto notificationDto);
}
