package anycomp.marketplace.com.service;

import anycomp.marketplace.com.dto.BuyerDto;

import java.util.List;

public interface BuyerService {
    /** Create new buyer **/
    BuyerDto createBuyer(BuyerDto buyerDto);

    /** Get buyers **/
    List<BuyerDto> getAllBuyer();

    /** Get specific buyer **/
    BuyerDto getBuyerById(Long buyerId);

    /** Update buyer **/
    BuyerDto updateBuyer(Long buyerId, BuyerDto updatedBuyerDto);

    /** Delete specific buyer **/
    void deleteBuyer(Long buyerId);
}
