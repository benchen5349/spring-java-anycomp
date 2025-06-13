package anycomp.marketplace.com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    @JsonIgnore
    private Seller seller;

    // Constructor
    public Item(
            Long id,
            String name,
            String description,
            Double price,
            int quantity
    ) {}

}
