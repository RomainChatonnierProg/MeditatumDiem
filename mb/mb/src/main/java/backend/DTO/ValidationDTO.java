package backend.DTO;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class ValidationDTO extends BaseDTO {
    @NotNull
    private Date expiry_at;

    @NotNull
    private Date activate_at;

    @NotNull
    private Long code;
    
    @NotNull
    private MdUserDTO mdUser;
}
