package com.notification.kafka.consumer;

import com.notification.dto.NotificationDto;
import com.notification.enums.ServiceName;
import com.notification.kafka.producer.KafkaProducer;
import com.notification.service.NotificationManager;
import com.notification.service.NotificationService;
import com.notification.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    private final JsonUtil jsonUtil;

    private final KafkaProducer kafkaProducer;

    private final NotificationManager notificationManager;

    private final NotificationService notificationService;

    @KafkaListener(topics = "notify", groupId = "notifications", containerFactory = "kafkaListenerContainerFactory")
    public void readMessage(String message) {
        log.info("Message received: {}", message);

        NotificationDto notificationDto = jsonUtil.fromJson(message, NotificationDto.class);
        String serviceName = notificationDto.getServiceName();

        switch (serviceName) {
            case "order-service":
                notificationService.messageFromOrderService(notificationDto);
                break;

            case "inventory-service":
                notificationService.messageFromInventoryService(notificationDto);
                break;

            case "payment-service":
                break;
        }
    }

}
