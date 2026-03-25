package com.ejemplonosql.ecommerce.infrastructure.mongo;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ejemplonosql.ecommerce.domain.model.EventLog;

@Repository
public interface EventLogRepository extends MongoRepository<EventLog, String> {

    List<EventLog> findByUserId(Long userId);

    @Query(value ="{'type': ?0 }")
    List<EventLog> findByTypeInfo(String info);

}
