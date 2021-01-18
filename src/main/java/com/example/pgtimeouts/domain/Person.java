package com.example.pgtimeouts.domain;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("person")
public class Person {

	@Id
	private Integer id;

	private String name;
}
