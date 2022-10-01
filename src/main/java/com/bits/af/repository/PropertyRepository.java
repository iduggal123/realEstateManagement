package com.bits.af.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bits.af.entities.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {

	boolean existsByPropertyUniqueId(String propertyUniqueId);

//	@Modifying
//	@Query("update Property p set p.pty_category = ?1 where p.id = ?2")
//	void setPropertyCategoryById(String propertyCategory, int propertyId);
//
//	@Modifying
//	@Query("update Property p set p.pty_price = ?1 where p.id = ?2")
//	void setPropertyPriceById(float propertyPrice, int propertyId);
//
//	@Modifying
//	@Query("update Property p set p.pty_type = ?1 where p.i = ?2")
//	void setPropertyTypeById(String propertyType, int propertyId);
}
