package anycomp.marketplace.com.service;

import anycomp.marketplace.com.dto.PurchaseDto;

import java.util.List;

public interface PurchaseService {
    /** Get specific purchase **/
    PurchaseDto getPurchaseById(Long purchaseId);

    /** Get all purchases **/
    List<PurchaseDto> getAllPurchases();

    /** Make purchase **/
    PurchaseDto createPurchase(Long buyerId, Long itemId, PurchaseDto purchaseDto);

    /** Get all purchases by pagination **/
    List<PurchaseDto> getAllPurchasesByPagination(int page, int pageSize);
}
