package com.example.desafiobackenditarc.dto.request;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
public class NotifyForecastRequestDTO {
    @NotEmpty
    private String cityName;
    @Valid
    private Integer notificationId;
}
