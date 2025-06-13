package anycomp.marketplace.com.repository;

import anycomp.marketplace.com.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
