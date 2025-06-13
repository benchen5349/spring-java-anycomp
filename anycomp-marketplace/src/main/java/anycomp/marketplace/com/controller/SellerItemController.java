package anycomp.marketplace.com.controller;

import anycomp.marketplace.com.dto.ItemDto;
import anycomp.marketplace.com.service.SellerItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/{id}/items")
public class SellerItemController {

    private SellerItemService sellerItemService;

    /**
     * API to create new seller and store
     * @param sellerId
     * @param itemDto
     * @return
     */
    @PostMapping()
    public ResponseEntity<ItemDto> createItemToSeller(@PathVariable("id") Long sellerId, @RequestBody ItemDto itemDto) {
        ItemDto stored = sellerItemService.createItemToSeller(sellerId, itemDto);
        return new ResponseEntity<>(stored, HttpStatus.CREATED);
    }

    /**
     * API to retrieve all seller's items
     * @return
     */
    @GetMapping
    public ResponseEntity<List<ItemDto>> getAllItemToSeller(@PathVariable("id") Long sellerId) {
        List<ItemDto> items = sellerItemService.getAllItemToSeller(sellerId);
        return ResponseEntity.ok(items);
    }
}
