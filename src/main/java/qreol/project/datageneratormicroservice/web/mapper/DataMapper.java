package qreol.project.datageneratormicroservice.web.mapper;

import org.mapstruct.Mapper;
import qreol.project.datageneratormicroservice.model.Data;
import qreol.project.datageneratormicroservice.web.dto.DataDto;

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<Data, DataDto> {
}
