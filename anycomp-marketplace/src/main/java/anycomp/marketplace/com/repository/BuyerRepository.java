package anycomp.marketplace.com.repository;

import anycomp.marketplace.com.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
