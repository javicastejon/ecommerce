package com.ejemplonosql.ecommerce.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ejemplonosql.ecommerce.domain.model.EventLog;
import com.ejemplonosql.ecommerce.domain.repository.EventLogRepository;

@Service
public class EventLogService {

    @Autowired
    private EventLogRepository eventLogRepository;

    /**
     * Guarda un evento de log en MongoDB
     */
    public void log(String type, String message, String userId) {

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

    /**
     * Recupera todos los registros con paginacion
     * @param pageable
     * @return
     */
    public Page<EventLog> findAllByPage(Pageable pageable){
        return eventLogRepository.findAll(pageable);
    }

    /**
     * Dado un mensaje devuelve los eventos ordenados por fecha. 
     * Basado en una consulta derivada de MongoRepository
     * @param message
     * @return List<EventLog>
     */
    public List<EventLog> getByMessageSortByTimeStamp(String message){
        return eventLogRepository.getByMessageSortByTimeStamp(message);
    }

    /**
     * Dado un mensaje devuelve los eventos ordenados por fecha.
     * Basado en una @Query
     * @param message
     * @return List<EventLog>
     */
    public List<EventLog> getByTimeStamp(LocalDateTime date_start){
        LocalDateTime date_end = LocalDateTime.now();
        return eventLogRepository.findByTimestampQuery(date_start, date_end);
    }


}
