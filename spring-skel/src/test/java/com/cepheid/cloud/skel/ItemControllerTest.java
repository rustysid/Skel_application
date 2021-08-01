package com.cepheid.cloud.skel;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.cepheid.cloud.skel.constant.StatusConst;
import com.cepheid.cloud.skel.model.Item;

import net.minidev.json.JSONObject;

@RunWith(SpringRunner.class)
public class ItemControllerTest extends TestBase {


	@Autowired
	JdbcTemplate jdbcTemplate;
	
  @Test
  public void testGetItems() throws Exception {
    Builder itemController = getBuilder("/app/api/1.0/items");
    
    Collection<Item> items = itemController.get(new GenericType<Collection<Item>>() {
    });


    Assert.assertNotNull(items);
    Assert.assertEquals(items.size(),4);
    
   
  }
  
}
