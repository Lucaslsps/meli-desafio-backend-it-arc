package com.example.desafiobackenditarc.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class ScheduleForecastRequestDTO {
    private String cityName;
    private Date notificationDate;
}
