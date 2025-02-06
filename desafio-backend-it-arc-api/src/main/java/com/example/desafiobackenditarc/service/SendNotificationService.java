package com.example.desafiobackenditarc.service;

import com.example.desafiobackenditarc.exception.CPTECException;
import com.example.desafiobackenditarc.exception.EntityNotFoundException;

public interface SendNotificationService {
    void notifyUsers(final String cityName) throws EntityNotFoundException, CPTECException;
}
