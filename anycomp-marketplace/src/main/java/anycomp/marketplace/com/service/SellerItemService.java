package anycomp.marketplace.com.service;

import anycomp.marketplace.com.dto.ItemDto;

import java.util.List;

public interface SellerItemService {
    /** Create new item for the seller **/
    ItemDto createItemToSeller(Long sellerId, ItemDto itemDto);

    /** Get all items belong to the seller **/
    List<ItemDto> getAllItemToSeller(Long sellerId);
}
