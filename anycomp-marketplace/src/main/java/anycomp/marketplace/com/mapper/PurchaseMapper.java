package anycomp.marketplace.com.mapper;

import anycomp.marketplace.com.dto.PurchaseDto;
import anycomp.marketplace.com.entity.Purchase;

public class PurchaseMapper {
    /**
     * Convert purchase into purchaseDto
     **/
    public static PurchaseDto mapToPurchaseDto(Purchase purchase) {
        return new PurchaseDto(
                purchase.getId(),
                purchase.getQuantity(),
                purchase.getPurchaseDate(),
                purchase.getBuyer().getId(),
                purchase.getItem().getId()
        );
    }

    /**
     * Convert purchaseDto into purchase
     **/
    public static Purchase mapToPurchase(PurchaseDto purchaseDto) {
        return new Purchase(
                purchaseDto.getId(),
                purchaseDto.getQuantity(),
                purchaseDto.getPurchaseDate()
        );
    }
}
