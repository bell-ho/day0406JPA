package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Category {
	@Id
	private int cid;
	private String type;
	
	@OneToMany(mappedBy = "category",fetch = FetchType.EAGER) //1:N 관계
	private List<Product>products;
}
