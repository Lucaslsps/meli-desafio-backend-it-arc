package com.example.desafiobackenditarc.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class NotifyForecastDTO {
    private String cityName;
    private Date notificationDate;
}
