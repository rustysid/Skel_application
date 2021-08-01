package com.cepheid.cloud.skel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cepheid.cloud.skel.constant.StatusConst;
import com.cepheid.cloud.skel.model.Item;


public interface ItemRepository extends JpaRepository<Item, Long> {

	Optional<Item> findByStatus(StatusConst status);

}
