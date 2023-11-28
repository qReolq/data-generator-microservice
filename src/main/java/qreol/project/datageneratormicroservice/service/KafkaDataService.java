package qreol.project.datageneratormicroservice.service;

import qreol.project.datageneratormicroservice.model.Data;

public interface KafkaDataService {

    void send(Data data);

}
