package qreol.project.datageneratormicroservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qreol.project.datageneratormicroservice.model.Data;
import qreol.project.datageneratormicroservice.model.test.DataTestOptions;
import qreol.project.datageneratormicroservice.service.KafkaDataService;
import qreol.project.datageneratormicroservice.service.TestDataService.TestDataService;
import qreol.project.datageneratormicroservice.web.dto.DataDto;
import qreol.project.datageneratormicroservice.web.dto.DataTestOptionsDto;
import qreol.project.datageneratormicroservice.web.mapper.DataMapper;
import qreol.project.datageneratormicroservice.web.mapper.DataTestOptionsMapper;

@RestController
@RequestMapping("/api/v1/data")
@RequiredArgsConstructor
public class DataController {

    private final KafkaDataService kafkaDataService;
    private final TestDataService testDataService;

    private final DataMapper mapper;
    private final DataTestOptionsMapper testOptionsMapper;

    @PostMapping("/send")
    public void send(@RequestBody DataDto dto) {
        Data data = mapper.toEntity(dto);
        kafkaDataService.send(data);
    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody DataTestOptionsDto testOptionDto) {
        DataTestOptions testOptions = testOptionsMapper.toEntity(testOptionDto);
        testDataService.sendMessages(testOptions);
    }

}
