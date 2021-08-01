package com.cepheid.cloud.skel;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.cepheid.cloud.skel.constant.StatusConst;
import com.cepheid.cloud.skel.model.Item;
import javax.ws.rs.core.MediaType;


@RunWith(SpringRunner.class)
public class ItemControllerTest extends TestBase {


  @Test
  public void testGetItems() throws Exception {
    Builder itemController = getBuilder("/app/api/1.0/items");
    
    Collection<Item> items = itemController.get(new GenericType<Collection<Item>>() {
    });


    Assert.assertNotNull(items);
    Assert.assertEquals(items.size(),4);
    
   
  }
  
  @Test
  public void testGetItemsById() throws Exception {
    Builder itemController = getBuilder("/app/api/1.0/items/1");
    
    Response item = itemController.get();

    Assert.assertNotNull(item);
    Assert.assertEquals("Should return status 200", 200, item.getStatus());
    Assert.assertNotNull("Should return user object as json", item.getEntity());
    Assert.assertEquals(1L, item.readEntity(Item.class).getId(),0);
  }
  
  @Test
  public void testPostItem() throws Exception {
    Builder itemController = getBuilder("/app/api/1.0/items");
    Item item = new Item().setName("test").setStatus(StatusConst.invalid);
    item.setId(5L);
    Entity<Item> entity = Entity.entity(item, MediaType.APPLICATION_JSON);
    Response res = itemController.post(entity);
    Assert.assertEquals("Should return status 200", 200, res.getStatus());
  }


  
}
