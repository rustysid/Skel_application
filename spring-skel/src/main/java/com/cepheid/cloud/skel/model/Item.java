package com.cepheid.cloud.skel.model;

import org.hibernate.annotations.Cascade;

import com.cepheid.cloud.skel.constant.StatusConst;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item")
public class Item extends AbstractEntity {

	@Enumerated(EnumType.STRING)
    private StatusConst status;

    private String name;

    
    @OneToMany(
    		fetch = FetchType.EAGER,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Description> descriptions = new ArrayList<Description>();
    
    public List<Description> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<Description> descriptions) {
		this.descriptions = descriptions;
	}

	public StatusConst getStatus() {
        return status;
    }

    public Item setStatus(StatusConst status) {
        this.status = status;
        return this;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }



    @Override
    public String toString() {
        return "Item{" +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                 '\'' +
                '}';
    }
}
