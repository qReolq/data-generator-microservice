package qreol.project.datageneratormicroservice.model.test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import qreol.project.datageneratormicroservice.model.MeasurementType;

@NoArgsConstructor
@Getter
@Setter
public class DataTestOptions {

    private int delayInSecond;
    private MeasurementType[] measurementTypes;

}
