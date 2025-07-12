package com.notification.serviceImpl;

import com.notification.constant.CommonConstant;
import com.notification.dto.InventoryRequestDto;
import com.notification.dto.NotificationDto;
import com.notification.dto.OrderResponseDto;
import com.notification.kafka.producer.KafkaProducer;
import com.notification.service.NotificationManager;
import com.notification.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationManagerImpl implements NotificationManager {

    private final KafkaProducer kafkaProducer;

    private final JsonUtil jsonUtil;

    public void handelOrderCreated(NotificationDto dto) {

        NotificationDto notificationDto = createInventoryRequestNotificationDto(dto);
        kafkaProducer.sendMessage(CommonConstant.ORDER_CREATED_TOPIC, jsonUtil.toJson(notificationDto));
    }

    public void handelOrderNotCreated(NotificationDto notificationDto) {
        kafkaProducer.sendMessage(CommonConstant.ORDER_ORDER_REJECTED, jsonUtil.toJson(notificationDto));
    }

    @Override
    public void handelInventoryNotCreated(NotificationDto notificationDto) {

    }

    @Override
    public void handelInventoryCreated(NotificationDto notificationDto) {
        jsonUtil.fromJson(notificationDto.getMessage(), null);
    }

    public NotificationDto createInventoryRequestNotificationDto(NotificationDto notificationDto) {

        OrderResponseDto orderResponseDto = jsonUtil.fromJson(notificationDto.getMessage(), OrderResponseDto.class);

        InventoryRequestDto inventoryRequestDto = InventoryRequestDto.builder()
                .stockId(orderResponseDto.getStockId())
                .quantity(orderResponseDto.getQuantity())
                .userId(orderResponseDto.getUserId())
                .totalAmount(orderResponseDto.getTotalAmount())
                .build();

        String message = jsonUtil.toJson(inventoryRequestDto);

        return NotificationDto
                .builder()
                .message(message)
                .serviceName("inventory-service")
                .build();
    }
}
