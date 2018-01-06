package com.singh.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GenericJPAModel {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="ID", nullable = false)
        private Integer id;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }



}