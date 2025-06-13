package anycomp.marketplace.com.mapper;

import anycomp.marketplace.com.dto.ItemDto;
import anycomp.marketplace.com.entity.Item;

public class ItemMapper {
    /**
     * Convert item into itemDto
     **/
    public static ItemDto mapToItemDto(Item item) {
        return new ItemDto(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.getQuantity()
        );
    }

    /**
     * Convert itemDto into item
     **/
    public static Item mapToItem(ItemDto itemDto) {
        return new Item(
                itemDto.getId(),
                itemDto.getName(),
                itemDto.getDescription(),
                itemDto.getPrice(),
                itemDto.getQuantity()
        );
    }
}
