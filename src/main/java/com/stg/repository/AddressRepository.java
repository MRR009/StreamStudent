package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.stg.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	// @Query("SELECT u FROM university u where u.university_code = :univ_code")

	@Modifying
	@Transactional
	@Query(value = "UPDATE address SET university_fk = :uni_id WHERE address_id = :address_id ", nativeQuery = true)
	public void updateUniversityAddress(@Param("uni_id") int uniId, @Param("address_id") int addressId );

}
