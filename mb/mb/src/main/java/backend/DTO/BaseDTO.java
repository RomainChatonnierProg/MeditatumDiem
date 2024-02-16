package backend.DTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public abstract class BaseDTO implements Serializable {
    private UUID id;
    private String createdAt;
    private String updatedAt;
}
