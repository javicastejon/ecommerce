package com.ejemplonosql.ecommerce.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplonosql.ecommerce.domain.model.EventLog;
import com.ejemplonosql.ecommerce.infrastructure.mongo.EventLogRepository;

@Service
public class EventLogService {

    @Autowired
    private EventLogRepository eventLogRepository;

    /**
     * Guarda un evento de log en MongoDB
     */
    public void log(String type, String message, Long userId) {

        EventLog event = new EventLog();
        event.setType(type);
        event.setMessage(message);
        event.setUserId(userId);
        event.setTimestamp(LocalDateTime.now());

        eventLogRepository.save(event);
    }

    /**
     * Devuelve todos los logs de un usuario
     */
    public List<EventLog> getLogsByUser(Long userId) {
        return eventLogRepository.findByUserId(userId);
    }

    /**
     * Devuelve todos los logs del sistema
     */
    public List<EventLog> getAllLogs() {
        return eventLogRepository.findAll();
    }


    public List<EventLog> findByTypeInfo( ){
        return eventLogRepository.findByTypeInfo("USER_UPDATE");
    }
}
