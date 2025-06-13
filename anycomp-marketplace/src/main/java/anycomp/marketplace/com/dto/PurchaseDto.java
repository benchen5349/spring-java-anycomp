package anycomp.marketplace.com.dto;

import lombok.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDto {
    private Long id;
    private int quantity;
    private Timestamp purchaseDate;
    private Long buyerId;
    private Long itemId;
}
