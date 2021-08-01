package com.cepheid.cloud.skel.controller;

import com.cepheid.cloud.skel.constant.StatusConst;
import com.cepheid.cloud.skel.model.Description;
import com.cepheid.cloud.skel.model.Item;
import com.cepheid.cloud.skel.repository.ItemRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.format.DecimalStyle;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


// curl http:/localhost:9443/app/api/1.0/items

@Component
@Path("/api/1.0/items")
@Api()
public class ItemController {

    private final ItemRepository mItemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        mItemRepository = itemRepository;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Item> getItemById(@PathParam("id") Long id) {
        Optional<Item> item = mItemRepository.findById(id);
        return new ResponseEntity<>(item, HttpStatus.CREATED).getBody();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public Collection<Item> getItems() {
        return mItemRepository.findAll();
    }
    
    @GET
    @Path("/status/{status}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Item> getItemByStatus(@PathParam("status") StatusConst status) {
        Optional<Item> item = mItemRepository.findByStatus(status);
        return new ResponseEntity<>(item, HttpStatus.CREATED).getBody();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Item createItem(@Valid @RequestBody Item item) {
        var newItem = item;
        mItemRepository.save(newItem);
        //return ResponseEntity.status(HttpStatus.CREATED).build();
        return new ResponseEntity<>(item, HttpStatus.CREATED).getBody();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Item updateItem(@PathParam(value = "id") Long id) {
        Optional<Item> item = mItemRepository.findById(id);
        mItemRepository.save(item.get());
        return item.get();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Item deleteItem(@PathParam(value = "id") Long id) {
        Optional<Item> item = mItemRepository.findById(id);
        mItemRepository.delete(item.get());
        return item.get();
    }


}
