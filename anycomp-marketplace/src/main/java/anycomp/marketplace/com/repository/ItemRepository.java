package anycomp.marketplace.com.repository;

import anycomp.marketplace.com.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    // find all items belong to the seller id
    List<Item> findAllBySellerId(Long sellerId);
}
