package anycomp.marketplace.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;
    private Timestamp purchaseDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    @JsonIgnore
    private Buyer buyer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @JsonIgnore
    private Item item;

    // Constructor
    public Purchase(Long id, int quantity, Timestamp purchaseDate) {
    }
}
