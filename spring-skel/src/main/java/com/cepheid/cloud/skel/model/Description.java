package com.cepheid.cloud.skel.model;

import javax.persistence.*;

@Entity
@Table(name = "description")
public class Description extends AbstractEntity{
	
	


	private String type;


	
    public String getType() {
        return type;
    }

    public Description setType(String type) {
        this.type = type;
        return this;
    }


}
