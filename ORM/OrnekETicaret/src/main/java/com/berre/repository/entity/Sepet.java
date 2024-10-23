package com.berre.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;

@NoArgsConstructor // boş constuctor
@AllArgsConstructor // dolu constuructor
@Data  //getter/setter/toString
@Entity
@Builder
@Table(name = "tblsepet")
public class Sepet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * K-> urun idleri olaracak
     * V -> adetleri olacak
     */
    @ElementCollection
    Map<Long, Integer> urunids;

    Long musteriid;

    @Embedded
   BaseEntity baseEntity;


}
