package anycomp.marketplace.com.controller;

import anycomp.marketplace.com.dto.SellerDto;
import anycomp.marketplace.com.service.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/sellers")
public class SellerController {

    private SellerService sellerService;

    /**
     * API to create new seller and store
     * @param sellerDto
     * @return
     */
    @PostMapping
    public ResponseEntity<SellerDto> createSeller(@RequestBody SellerDto sellerDto) {
        SellerDto stored = sellerService.createSeller(sellerDto);
        return new ResponseEntity<>(stored, HttpStatus.CREATED);
    }

    /**
     * API to retrieve seller by id
     * @param sellerId
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<SellerDto> getSellerById(@PathVariable("id") Long sellerId) {
        SellerDto sellerDto = sellerService.getSellerById(sellerId);
        return ResponseEntity.ok(sellerDto);
    }

    /**
     * API to retrieve all sellers
     * @return
     */
    @GetMapping
    public ResponseEntity<List<SellerDto>> getAllSellers() {
        List<SellerDto> sellers = sellerService.getAllSeller();
        return ResponseEntity.ok(sellers);
    }

    /**
     * API to update seller
     * @param sellerId
     * @param updatedSellerDto
     * @return
     */
    @PutMapping("{id}")
    public ResponseEntity<SellerDto> updateSeller(@PathVariable("id") Long sellerId, @RequestBody SellerDto updatedSellerDto) {
        SellerDto sellerDto = sellerService.updateSeller(sellerId, updatedSellerDto);
        return ResponseEntity.ok(sellerDto);
    }

    /**
     * API to remove seller by id
     * @param sellerId
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSeller(@PathVariable("id") Long sellerId) {
        sellerService.deleteSeller(sellerId);
        return new ResponseEntity<>("Successfully delete selected seller.", HttpStatus.OK);
    }
}
