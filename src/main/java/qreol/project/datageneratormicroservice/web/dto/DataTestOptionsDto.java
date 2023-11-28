package qreol.project.datageneratormicroservice.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import qreol.project.datageneratormicroservice.model.MeasurementType;

@NoArgsConstructor
@Getter
@Setter
public class DataTestOptionsDto {

    private int delayInSecond;
    private MeasurementType[] measurementTypes;

}
