package anycomp.marketplace.com.service;

import anycomp.marketplace.com.dto.SellerDto;

import java.util.List;

public interface SellerService {
    /** Create new seller **/
    SellerDto createSeller(SellerDto sellerDto);

    /** Get specific seller **/
    SellerDto getSellerById(Long sellerId);

    /** Get sellers **/
    List<SellerDto> getAllSeller();

    /** Update seller **/
    SellerDto updateSeller(Long sellerId, SellerDto updatedSellerDto);

    /** Delete specific seller **/
    void deleteSeller(Long sellerId);
}
