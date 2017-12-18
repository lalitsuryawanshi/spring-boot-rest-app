package org.se.bou.quote.repository;

import org.se.bou.quote.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
