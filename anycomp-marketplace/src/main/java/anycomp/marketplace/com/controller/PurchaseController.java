package anycomp.marketplace.com.controller;

import anycomp.marketplace.com.dto.ItemDto;
import anycomp.marketplace.com.dto.PurchaseDto;
import anycomp.marketplace.com.service.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/purchases")
public class PurchaseController {

    private PurchaseService purchaseService;

    /**
     * API to retrieve purchase by id
     * @param purchaseId
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<PurchaseDto> getPurchaseById(@PathVariable("id") Long purchaseId) {
        PurchaseDto purchaseDto = purchaseService.getPurchaseById(purchaseId);
        return ResponseEntity.ok(purchaseDto);
    }

    /**
     * API to retrieve all purchases
     * @return
     */
    @GetMapping
    public ResponseEntity<List<PurchaseDto>> getAllPurchases() {
        List<PurchaseDto> purchases = purchaseService.getAllPurchases();
        return ResponseEntity.ok(purchases);
    }

    /**
     * API to create new purchase and store
     * @param buyerId
     * @param purchaseDto
     * @return
     */
    @PostMapping("{buyerId}/{itemId}")
    public ResponseEntity<PurchaseDto> createPurchase(@PathVariable("buyerId") Long buyerId, @PathVariable("itemId") Long itemId, @RequestBody PurchaseDto purchaseDto) {
        PurchaseDto stored = purchaseService.createPurchase(buyerId, itemId, purchaseDto);
        return new ResponseEntity<>(stored, HttpStatus.CREATED);
    }

    /**
     * API to retrieve all purchases by pagination
     * @return
     */
    @GetMapping("pagination/{page}/{pageSize}")
    public ResponseEntity<List<PurchaseDto>> getAllPurchasesByPagination(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize) {
        List<PurchaseDto> purchases = purchaseService.getAllPurchasesByPagination(page, pageSize);
        return ResponseEntity.ok(purchases);
    }
}
