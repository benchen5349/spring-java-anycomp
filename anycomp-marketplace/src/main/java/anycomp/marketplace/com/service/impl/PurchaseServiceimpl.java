package anycomp.marketplace.com.service.impl;

import anycomp.marketplace.com.dto.PurchaseDto;
import anycomp.marketplace.com.entity.Buyer;
import anycomp.marketplace.com.entity.Item;
import anycomp.marketplace.com.entity.Purchase;
import anycomp.marketplace.com.exception.OutStockException;
import anycomp.marketplace.com.exception.ResourceNotFoundException;
import anycomp.marketplace.com.mapper.PurchaseMapper;
import anycomp.marketplace.com.repository.BuyerRepository;
import anycomp.marketplace.com.repository.ItemRepository;
import anycomp.marketplace.com.repository.PurchaseRepository;
import anycomp.marketplace.com.service.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PurchaseServiceimpl implements PurchaseService {

    private PurchaseRepository purchaseRepository;
    private BuyerRepository buyerRepository;
    private ItemRepository itemRepository;

    /**
     * get purchase by id method
     * @param purchaseId
     * @return
     */
    @Override
    public PurchaseDto getPurchaseById(Long purchaseId) {
        Purchase purchase = purchaseRepository.findById(purchaseId)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase not found from given id: " + purchaseId));

        return PurchaseMapper.mapToPurchaseDto(purchase);
    }

    /**
     * get all the purchases method
     * @return
     */
    @Override
    public List<PurchaseDto> getAllPurchases() {
        List<Purchase> purchases = purchaseRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));

        return purchases
                .stream()
                .map(PurchaseMapper::mapToPurchaseDto)
                .collect(Collectors.toList());
    }

    @Override
    public PurchaseDto createPurchase(Long buyerId, Long itemId, PurchaseDto purchaseDto) {
        Buyer buyer = buyerRepository.findById(buyerId)
                .orElseThrow(() -> new ResourceNotFoundException("Buyer not found from given id: " + buyerId));

        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found from given id: " + itemId));

        // quantity less than 0
        if(item.getQuantity() < 1) {
            throw new OutStockException("Item out of stock.");
        }

        // compare purchase quantity & current item quantity
        if(purchaseDto.getQuantity() > item.getQuantity()) {
            throw new OutStockException("Item not enough stock to be purchased. Stock left: (" + (item.getQuantity() - purchaseDto.getQuantity()) + ")");
        }

        Purchase purchase = PurchaseMapper.mapToPurchase(purchaseDto);

        purchase.setBuyer(buyer);
        purchase.setItem(item);
        purchase.setQuantity(purchaseDto.getQuantity());
        purchase.setPurchaseDate(purchaseDto.getPurchaseDate());

        Purchase save = purchaseRepository.save(purchase);

        // update item quantity
        item.setQuantity(item.getQuantity() - save.getQuantity());
        itemRepository.save(item);

        return PurchaseMapper.mapToPurchaseDto(save);
    }

    @Override
    public List<PurchaseDto> getAllPurchasesByPagination(int page, int pageSize) {
        Page<Purchase> purchases = purchaseRepository.findAll(PageRequest.of(page, pageSize));

        return purchases
                .stream()
                .map(PurchaseMapper::mapToPurchaseDto)
                .collect(Collectors.toList());
    }
}
