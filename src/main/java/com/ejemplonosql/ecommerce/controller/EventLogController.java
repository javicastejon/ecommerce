package com.ejemplonosql.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplonosql.ecommerce.domain.model.EventLog;
import com.ejemplonosql.ecommerce.dto.EventLogRequest;
import com.ejemplonosql.ecommerce.service.EventLogService;

@RestController
@RequestMapping("api/v1/eventlog")
@CrossOrigin(origins= "*")
public class EventLogController {

    @Autowired
    private EventLogService eventLogService;


    @GetMapping("/getall")
    public List<EventLog> getEventLogs(){
        return eventLogService.getAllLogs();
    }

    @PostMapping
    public List<EventLog> getEventByMessage(@RequestBody EventLogRequest eventLog) {
        return eventLogService.getByMessageSortByTimeStamp(eventLog.getMessage());
    }

    @PostMapping("/date")
    public List<EventLog> createUser(@RequestBody EventLogRequest eventLog) {
        return eventLogService.getByTimeStamp(eventLog.getDate());
    }

    /**
     * Ejemplo de paginacion con MongoDB
     * @param page Número de página
     * @param sizePerPage Tamaño de página
     * @param sortField Campo para ordenar
     * @param sortDirection Ordenado ASC o DESC
     * @return Lista de eventos paginados con la información de página para volver a lanzar query
     */
    @GetMapping
    public Page<EventLog> findAllByPage(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "2") int sizePerPage,
                                        @RequestParam(defaultValue = "timestamp") String sortField,
                                        @RequestParam(defaultValue = "DESC") Sort.Direction sortDirection){
        Pageable pageable = PageRequest.of(page, sizePerPage, sortDirection, sortField);
                                            return eventLogService.findAllByPage(pageable);
    }
}
