package com.ejemplonosql.ecommerce.infrastructure.mongo;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ejemplonosql.ecommerce.domain.model.EventLog;

@Repository
public interface EventLogRepository extends MongoRepository<EventLog, String> {

    List<EventLog> findByUserId(Long userId);

}
