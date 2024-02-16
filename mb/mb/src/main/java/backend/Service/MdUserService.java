package backend.Service;

import backend.DTO.MdUserDTO;
import backend.Entity.MdUser;
import backend.Mapper.MdUserMapper;
import backend.Repository.MdUserRepository;


public class MdUserService extends BaseService<MdUser, MdUserDTO>{
    
    private final MdUserRepository repository;
    private final MdUserMapper mapper;
    
    public MdUserService(MdUserRepository repository, MdUserMapper mapper){
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
