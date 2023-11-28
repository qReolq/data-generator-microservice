package qreol.project.datageneratormicroservice.web.mapper;

import org.mapstruct.Mapper;
import qreol.project.datageneratormicroservice.model.test.DataTestOptions;
import qreol.project.datageneratormicroservice.web.dto.DataTestOptionsDto;

@Mapper(componentModel = "spring")
public interface DataTestOptionsMapper extends Mappable<DataTestOptions, DataTestOptionsDto> {
}
