package anycomp.marketplace.com.service.impl;

import anycomp.marketplace.com.dto.ItemDto;
import anycomp.marketplace.com.entity.Item;
import anycomp.marketplace.com.exception.ResourceNotFoundException;
import anycomp.marketplace.com.mapper.ItemMapper;
import anycomp.marketplace.com.repository.ItemRepository;
import anycomp.marketplace.com.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    /**
     * get item by id method
     * @param itemId
     * @return
     */
    @Override
    public ItemDto getItemById(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found from given id: " + itemId));

        return ItemMapper.mapToItemDto(item);
    }

    /**
     * get all the items method
     * @return
     */
    @Override
    public List<ItemDto> getAllItem() {
        List<Item> items = itemRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return items
                .stream()
                .map(ItemMapper::mapToItemDto)
                .collect(Collectors.toList());
    }

    /**
     * find item and update method
     * @param itemId
     * @param updatedItemDto
     * @return
     */
    @Override
    public ItemDto updateItem(Long itemId, ItemDto updatedItemDto) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found from given id: " + itemId));

        item.setName(updatedItemDto.getName());
        item.setDescription(updatedItemDto.getDescription());
        item.setPrice(updatedItemDto.getPrice());
        item.setQuantity(updatedItemDto.getQuantity());
        //item.setSeller(item.getSeller());

        Item updatedObj = itemRepository.save(item);

        return ItemMapper.mapToItemDto(updatedObj);
    }

    /**
     * find item and delete method
     * @param itemId
     */
    @Override
    public void deleteItem(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found from given id: " + itemId));

        itemRepository.deleteById(itemId);
    }
}
