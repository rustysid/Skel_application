package com.cepheid.cloud.skel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cepheid.cloud.skel.model.Description;
@Repository
public interface DescriptionRepository extends JpaRepository<Description, Long> {
	

}
