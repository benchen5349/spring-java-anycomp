package anycomp.marketplace.com.service.impl;

import anycomp.marketplace.com.dto.ItemDto;
import anycomp.marketplace.com.entity.Item;
import anycomp.marketplace.com.entity.Seller;
import anycomp.marketplace.com.exception.ResourceNotFoundException;
import anycomp.marketplace.com.mapper.ItemMapper;
import anycomp.marketplace.com.repository.ItemRepository;
import anycomp.marketplace.com.repository.SellerRepository;
import anycomp.marketplace.com.service.SellerItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SellerItemServiceImpl implements SellerItemService {

    private SellerRepository sellerRepository;
    private ItemRepository itemRepository;

    /**
     * add item to the seller method
     * @param sellerId
     * @param itemDto
     * @return
     */
    @Override
    public ItemDto createItemToSeller(Long sellerId, ItemDto itemDto) {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new ResourceNotFoundException("Seller not found from the given id: " + sellerId));

        Item item = ItemMapper.mapToItem(itemDto);

        item.setName(itemDto.getName());
        item.setDescription(itemDto.getDescription());
        item.setPrice(itemDto.getPrice());
        item.setQuantity(itemDto.getQuantity());
        item.setSeller(seller);

        Item save = itemRepository.save(item);

        return ItemMapper.mapToItemDto(save);
    }

    /**
     * get all the item from the seller method
     * @return
     */
    @Override
    public List<ItemDto> getAllItemToSeller(Long sellerId) {
        List<Item> items = itemRepository.findAllBySellerId(sellerId);
        return items
                .stream()
                .map(ItemMapper::mapToItemDto)
                .collect(Collectors.toList());
    }
}
