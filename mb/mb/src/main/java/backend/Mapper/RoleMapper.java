package backend.Mapper;

import backend.DTO.RoleDTO;
import backend.Entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, 
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper extends BaseMapper<Role, RoleDTO> {
    @Override
    Role dtoToEntity(RoleDTO dto);

    @Override
    RoleDTO entityToDto(Role entity);

    @Override
    List<Role> dtoToEntities(List<RoleDTO> dtos);

    @Override
    List<RoleDTO> entityToDtos(List<Role> entities);
}