package anycomp.marketplace.com.service;

import anycomp.marketplace.com.dto.ItemDto;

import java.util.List;

public interface ItemService {
    /** Get specific item **/
    ItemDto getItemById(Long itemId);

    /** Get all items **/
    List<ItemDto> getAllItem();

    /** Update item **/
    ItemDto updateItem(Long itemId, ItemDto updatedItemDto);

    /** Delete specific item **/
    void deleteItem(Long itemId);
}
