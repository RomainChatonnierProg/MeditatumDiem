package backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Validation extends BaseEntity{
    @CreationTimestamp
    @Column(name = "expiry_at", nullable = false)
    private Date expiry_at;

    @CreationTimestamp
    @Column(name = "activate_at", nullable = false)
    private Date activate_at;

    @Column(name = "code", nullable = false)
    private Long code;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "md_mdUser_validation",
    joinColumns = @JoinColumn(name = "medi_user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "vali_id", referencedColumnName = "id"))
    private MdUser mdUser;
}
