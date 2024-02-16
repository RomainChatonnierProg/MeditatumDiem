package backend.Mapper;

import backend.DTO.MdUserDTO;
import backend.Entity.MdUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, 
        componentModel = "spring",
        uses = {RoleMapper.class})
public interface MdUserMapper extends BaseMapper<MdUser, MdUserDTO>{
    @Override
    @Mapping(target = "roles", ignore = true)
    MdUser dtoToEntity(MdUserDTO dto);

    @Override
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "roles", ignore = true)
    MdUserDTO entityToDto(MdUser entity);

    @Override
    List<MdUser> dtoToEntities(List<MdUserDTO> dtos);

    @Override
    List<MdUserDTO> entityToDtos(List<MdUser> entities);
}
