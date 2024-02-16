package backend.Mapper;

import backend.DTO.ValidationDTO;
import backend.Entity.Validation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, 
        componentModel = "spring",
        uses = {MdUserMapper.class})
public interface ValidationMapper extends BaseMapper<Validation, ValidationDTO> {

    @Override
    Validation dtoToEntity(ValidationDTO dto);

    @Override
    ValidationDTO entityToDto(Validation entity);

    @Override
    List<Validation> dtoToEntities(List<ValidationDTO> dtos);

    @Override
    List<ValidationDTO> entityToDtos(List<Validation> entities);
}
