package com.example.desafiobackenditarc.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class NotifyForecastRequestDTO {
    private String cityName;
    private Date notificationDate;
}
