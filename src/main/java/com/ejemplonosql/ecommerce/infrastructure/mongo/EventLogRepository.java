package com.ejemplonosql.ecommerce.infrastructure.mongo;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ejemplonosql.ecommerce.domain.model.EventLog;

@Repository
public interface EventLogRepository extends MongoRepository<EventLog, String> {

    //#region Consultas derivadas MongoRepository
    List<EventLog> findByUserId(Long userId);

    List<EventLog> findByType(String type);

    List<EventLog> findByTypeAndUserId(String type, String userId);

    List<EventLog> findByTimestampBetween(LocalDateTime start, LocalDateTime end);

    Page<EventLog> findAllByUserId(Long userId, Pageable pageable);
    //#endregion

    //#region Consultas basadas en query mediante anotacion @Query
    @Query(value ="{'type': ?0 }")
    List<EventLog> findByTypeInfo(String info);
   
    @Query(value = "{'timestamp': {'$gte': ?0, '$lte': ?1} }")
    List<EventLog> findByTimestampQuery(LocalDateTime start, LocalDateTime end);

    @Query(value="{message:?0}",sort="{timestamp:-1}")
    List<EventLog> getByMessageSortByTimeStamp(String message);
    //#endregion

}
