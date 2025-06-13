package anycomp.marketplace.com.controller;

import anycomp.marketplace.com.dto.ItemDto;
import anycomp.marketplace.com.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/items")
public class ItemController {

    private ItemService itemService;

    /**
     * API to retrieve item by id
     * @param itemId
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable("id") Long itemId) {
        ItemDto itemDto = itemService.getItemById(itemId);
        return ResponseEntity.ok(itemDto);
    }

    /**
     * API to retrieve all items
     * @return
     */
    @GetMapping
    public ResponseEntity<List<ItemDto>> getAllItems() {
        List<ItemDto> iiems = itemService.getAllItem();
        return ResponseEntity.ok(iiems);
    }

    /**
     * API to update item
     * @param itemId
     * @param updatedItemDto
     * @return
     */
    @PutMapping("{id}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable("id") Long itemId, @RequestBody ItemDto updatedItemDto) {
        ItemDto itemDto = itemService.updateItem(itemId, updatedItemDto);
        return ResponseEntity.ok(itemDto);
    }

    /**
     * API to remove item by id
     * @param itemId
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") Long itemId) {
        itemService.deleteItem(itemId);
        return new ResponseEntity<>("Successfully delete selected item.", HttpStatus.OK);
    }
}
