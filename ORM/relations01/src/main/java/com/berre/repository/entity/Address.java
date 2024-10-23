package com.berre.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "tbl_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String city;
    String street;
    String number;

    //@ManyToMany(mappedBy = "addresses",fetch = FetchType.EAGER)
    //List<Personel> personelList=new ArrayList<>();

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                //", personel ad=" + personelList.stream().map(Personel::getName).toList() +
                '}';
    }
}
