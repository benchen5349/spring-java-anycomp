package anycomp.marketplace.com.controller;

import anycomp.marketplace.com.dto.BuyerDto;
import anycomp.marketplace.com.service.BuyerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/buyers")
public class BuyerController {

    private BuyerService buyerService;

    /**
     * API to create new buyer and store
     * @param buyerDto
     * @return
     */
    @PostMapping
    public ResponseEntity<BuyerDto> createBuyer(@RequestBody BuyerDto buyerDto) {
        BuyerDto stored = buyerService.createBuyer(buyerDto);
        return new ResponseEntity<>(stored, HttpStatus.CREATED);
    }

    /**
     * API to retrieve buyer by id
     * @param buyerId
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<BuyerDto> getBuyerById(@PathVariable("id") Long buyerId) {
        BuyerDto buyerDto = buyerService.getBuyerById(buyerId);
        return ResponseEntity.ok(buyerDto);
    }

    /**
     * API to retrieve all buyers
     * @return
     */
    @GetMapping
    public ResponseEntity<List<BuyerDto>> getAllBuyers() {
        List<BuyerDto> buyers = buyerService.getAllBuyer();
        return ResponseEntity.ok(buyers);
    }

    /**
     * API to update buyer
     * @param buyerId
     * @param updatedBuyerDto
     * @return
     */
    @PutMapping("{id}")
    public ResponseEntity<BuyerDto> updateBuyer(@PathVariable("id") Long buyerId, @RequestBody BuyerDto updatedBuyerDto) {
        BuyerDto buyerDto = buyerService.updateBuyer(buyerId, updatedBuyerDto);
        return ResponseEntity.ok(buyerDto);
    }

    /**
     * API to remove buyer by id
     * @param buyerId
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBuyer(@PathVariable("id") Long buyerId) {
        buyerService.deleteBuyer(buyerId);
        return new ResponseEntity<>("Successfully delete selected buyer.", HttpStatus.OK);
    }
}
