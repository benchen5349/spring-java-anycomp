package anycomp.marketplace.com.mapper;

import anycomp.marketplace.com.dto.SellerDto;
import anycomp.marketplace.com.entity.Seller;

public class SellerMapper {
    /**
     * Convert seller into sellerDto
     **/
    public static SellerDto mapToSellerDto(Seller seller) {
        return new SellerDto(
                seller.getId(),
                seller.getName(),
                seller.getEmail(),
                seller.getItem()
        );
    }

    /**
     * Convert sellerDto into seller
     **/
    public static Seller mapToSeller(SellerDto sellerDto) {
        return new Seller(
                sellerDto.getId(),
                sellerDto.getName(),
                sellerDto.getEmail(),
                sellerDto.getItems()
        );
    }
}
