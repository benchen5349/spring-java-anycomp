package anycomp.marketplace.com.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "buyers")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Purchase> purchases = new ArrayList<>();

    public Buyer(
            Long id,
            String name,
            String email
    ) {}
}
