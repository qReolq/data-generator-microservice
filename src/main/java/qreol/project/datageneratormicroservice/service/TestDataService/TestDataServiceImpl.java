package qreol.project.datageneratormicroservice.service.TestDataService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qreol.project.datageneratormicroservice.model.Data;
import qreol.project.datageneratormicroservice.model.MeasurementType;
import qreol.project.datageneratormicroservice.model.test.DataTestOptions;
import qreol.project.datageneratormicroservice.service.KafkaDataService;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class TestDataServiceImpl implements TestDataService {

    private final ScheduledExecutorService executorService
            = Executors.newSingleThreadScheduledExecutor();
    private final KafkaDataService kafkaDataService;

    @Override
    public void sendMessages(DataTestOptions testOptions) {
        if (testOptions.getMeasurementTypes().length > 0) {
            executorService.scheduleAtFixedRate(
                    () -> {
                        Data data = new Data();
                        data.setSensorId((long) getRandomNumber(1, 10));
                        data.setMeasurement(getRandomNumber(15, 100));
                        data.setMeasurementType(getRandomMeasurementType(testOptions.getMeasurementTypes()));
                        data.setTimestamp(LocalDateTime.now());
                        kafkaDataService.send(data);
                    },
                    0,
                    testOptions.getDelayInSecond(),
                    TimeUnit.SECONDS
            );
        }
    }

    private double getRandomNumber(int min, int max) {
        return (Math.random() * (max - min) + min);
    }

    private MeasurementType getRandomMeasurementType(MeasurementType[] measurementTypes) {
        int randomId = (int) (Math.random() * measurementTypes.length);
        return measurementTypes[randomId];
    }

}
