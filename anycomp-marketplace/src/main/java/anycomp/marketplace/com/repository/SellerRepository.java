package anycomp.marketplace.com.repository;

import anycomp.marketplace.com.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
