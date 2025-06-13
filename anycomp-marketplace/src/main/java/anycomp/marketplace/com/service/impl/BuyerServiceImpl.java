package anycomp.marketplace.com.service.impl;

import anycomp.marketplace.com.dto.BuyerDto;
import anycomp.marketplace.com.entity.Buyer;
import anycomp.marketplace.com.exception.ResourceNotFoundException;
import anycomp.marketplace.com.mapper.BuyerMapper;
import anycomp.marketplace.com.repository.BuyerRepository;
import anycomp.marketplace.com.service.BuyerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BuyerServiceImpl implements BuyerService {

    private BuyerRepository buyerRepository;

    /**
     * crete new buyer method
     * @param buyerDto
     * @return
     */
    @Override
    public BuyerDto createBuyer(BuyerDto buyerDto) {
        Buyer buyer = BuyerMapper.mapToBuyer(buyerDto);
        Buyer save = buyerRepository.save(buyer);

        return BuyerMapper.mapToBuyerDto(save);
    }

    /**
     * get buyer by id method
     * @param buyerId
     * @return
     */
    @Override
    public BuyerDto getBuyerById(Long buyerId) {
        Buyer buyer = buyerRepository.findById(buyerId)
                .orElseThrow(() -> new ResourceNotFoundException("Buyer not found from the given id: " + buyerId));

        return BuyerMapper.mapToBuyerDto(buyer);
    }

    /**
     * get all the buyer method
     * @return
     */
    @Override
    public List<BuyerDto> getAllBuyer() {
        List<Buyer> buyers = buyerRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return buyers
                .stream()
                .map(BuyerMapper::mapToBuyerDto)
                .collect(Collectors.toList());
    }

    /**
     * find buyer and update method
     * @param buyerId
     * @param updatedBuyerDto
     * @return
     */
    @Override
    public BuyerDto updateBuyer(Long buyerId, BuyerDto updatedBuyerDto) {
        // find
        Buyer buyer = buyerRepository.findById(buyerId)
                .orElseThrow(() -> new ResourceNotFoundException("Buyer invalid from the given id: " + buyerId));

        // set
        buyer.setName(updatedBuyerDto.getName());
        buyer.setEmail(updatedBuyerDto.getEmail());

        Buyer updatedObj = buyerRepository.save(buyer);

        return BuyerMapper.mapToBuyerDto(updatedObj);

    }

    /**
     * find buyer and delete method
     * @param buyerId
     */
    @Override
    public void deleteBuyer(Long buyerId) {
        // find
        Buyer buyer = buyerRepository.findById(buyerId)
                .orElseThrow(() -> new ResourceNotFoundException("Buyer invalid from the given id: " + buyerId));

        buyerRepository.deleteById(buyerId);
    }
}
