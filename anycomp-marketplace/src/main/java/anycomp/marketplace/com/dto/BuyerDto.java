package anycomp.marketplace.com.dto;

import anycomp.marketplace.com.entity.Purchase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuyerDto {
    private Long id;
    private String name;
    private String email;
    private List<Purchase> purchases;
}
