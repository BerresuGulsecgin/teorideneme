package com.berre.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "tblurun")
@NamedQueries({
        @NamedQuery(name="Urun.findAll", query = "select u from Urun u"),
        @NamedQuery(name="Urun.findByAd", query = "select u from Urun u where u.ad like :urunad")
})
//@NamedQuery(name="Urun.findAll", query = "select u from Urun u")
//@NamedQuery(name="Urun.findByAd", query = "select u from Urun u where u.ad like :urunad")
public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String ad;
    String barkod;
    String marka;
    String model;
    BigDecimal fiyat;
    Integer stok;

    @Embedded
    BaseEntity baseEntity;




}
