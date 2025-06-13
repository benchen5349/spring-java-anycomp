package anycomp.marketplace.com.mapper;

import anycomp.marketplace.com.dto.BuyerDto;
import anycomp.marketplace.com.entity.Buyer;

public class BuyerMapper {
    /**
     * Convert buyer into buyerDto
     **/
    public static BuyerDto mapToBuyerDto(Buyer buyer) {
        return new BuyerDto(
                buyer.getId(),
                buyer.getName(),
                buyer.getEmail(),
                buyer.getPurchases()
        );
    }

    /**
     * Convert buyerDto into buyer
     **/
    public static Buyer mapToBuyer(BuyerDto buyerDto) {
        return new Buyer(
                buyerDto.getId(),
                buyerDto.getName(),
                buyerDto.getEmail(),
                buyerDto.getPurchases()
        );
    }
}
