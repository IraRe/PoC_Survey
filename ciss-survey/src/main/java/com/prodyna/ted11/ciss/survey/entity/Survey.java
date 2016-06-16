package com.prodyna.ted11.ciss.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Survey {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
}
