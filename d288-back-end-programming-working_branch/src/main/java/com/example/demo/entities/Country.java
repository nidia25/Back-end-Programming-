package com.example.demo.entities;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Objects;


import java.math.BigDecimal;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "countries")


public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    @Column(name = "country")
    private String country_name;

   @OneToMany(cascade = CascadeType.ALL)
   @JoinColumn(name = "country_id")
   private Set<Division> divisions;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

}