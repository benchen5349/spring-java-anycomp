package anycomp.marketplace.com.service.impl;

import anycomp.marketplace.com.dto.SellerDto;
import anycomp.marketplace.com.entity.Seller;
import anycomp.marketplace.com.exception.ResourceNotFoundException;
import anycomp.marketplace.com.mapper.SellerMapper;
import anycomp.marketplace.com.repository.SellerRepository;
import anycomp.marketplace.com.service.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SellerServiceImpl implements SellerService {
    private SellerRepository sellerRepository;


    /**
     * crete new seller method
     * @param sellerDto
     * @return
     */
    @Override
    public SellerDto createSeller(SellerDto sellerDto) {
        Seller seller = SellerMapper.mapToSeller(sellerDto);
        Seller save = sellerRepository.save(seller);

        return SellerMapper.mapToSellerDto(save);
    }

    /**
     * get selleer by id method
     * @param sellerId
     * @return
     */
    @Override
    public SellerDto getSellerById(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new ResourceNotFoundException("Seller not found from the given id: " + sellerId));

        return SellerMapper.mapToSellerDto(seller);
    }

    /**
     * get all the seller method
     * @return
     */
    @Override
    public List<SellerDto> getAllSeller() {
        List<Seller> sellers = sellerRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return sellers
                .stream()
                .map(SellerMapper::mapToSellerDto)
                .collect(Collectors.toList());
    }

    /**
     * find seller and update method
     * @param sellerId
     * @param updatedSellerDto
     * @return
     */
    @Override
    public SellerDto updateSeller(Long sellerId, SellerDto updatedSellerDto) {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new ResourceNotFoundException("Seller invalid from the given id: " + sellerId));

        seller.setName(updatedSellerDto.getName());
        seller.setEmail(updatedSellerDto.getEmail());

        Seller updatedObj = sellerRepository.save(seller);

        return SellerMapper.mapToSellerDto(updatedObj);
    }

    /**
     * find seller and delete method
     * @param sellerId
     */
    @Override
    public void deleteSeller(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new ResourceNotFoundException("Seller invalid from the given id: " + sellerId));

        sellerRepository.deleteById(sellerId);
    }
}
