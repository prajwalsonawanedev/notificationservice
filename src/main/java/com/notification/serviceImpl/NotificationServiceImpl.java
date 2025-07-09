package com.notification.serviceImpl;

import com.notification.dto.NotificationDto;
import com.notification.service.NotificationManager;
import com.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationManager notificationManager;

    public void messageFromOrderService(NotificationDto notificationDto) {

        if (notificationDto.getIsSuccess()) {
            notificationManager.handelOrderCreated(notificationDto);
        } else {
            notificationManager.handelOrderNotCreated(notificationDto);
        }
    }

    @Override
    public void messageFromInventoryService(NotificationDto notificationDto) {
        if (notificationDto.getIsSuccess()) {
            notificationManager.handelInventoryCreated(notificationDto);
        } else {
            notificationManager.handelInventoryNotCreated(notificationDto);
        }
    }
}
