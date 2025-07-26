package com.notification.kafka.consumer;

import com.notification.dto.MasterDto;
import com.notification.dto.NotificationDto;
import com.notification.service.NotificationService;
import com.notification.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    private final JsonUtil jsonUtil;

    private final NotificationService notificationService;

    public KafkaConsumer(NotificationService notificationService, JsonUtil jsonUtil) {
        this.jsonUtil = jsonUtil;
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "notify", groupId = "notifications", containerFactory = "kafkaListenerContainerFactory")
    public void readMessage(NotificationDto notificationDto) {
        log.info("Message received: {}", notificationDto);

//        NotificationDto notificationDto = jsonUtil.fromJson(message, NotificationDto.class);
//        MasterDto masterDto=jsonUtil.fromJson(message)
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
