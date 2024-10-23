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
@Builder
@Table(name="tblsatisdetay")
@Entity
public class SatisDetay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long satisid;
    Long urunid;
    Integer adet;
    BigDecimal fiyat;
    BigDecimal toplamFiyat;
    @Embedded
    BaseEntity baseEntity;




}
