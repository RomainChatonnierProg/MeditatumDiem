package backend.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDTO {
    @NotNull
    private Long id;
    
    @NotNull
    private String name;
}
