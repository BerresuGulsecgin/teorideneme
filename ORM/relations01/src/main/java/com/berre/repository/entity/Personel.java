package com.berre.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tbl_personel")
public class Personel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    Integer age;


    //bir personelin bir departmanı olut
    @ManyToOne()
    @Cascade(CascadeType.SAVE_UPDATE)
    Department department;

    @OneToOne
    @Cascade({CascadeType.SAVE_UPDATE,CascadeType.DELETE})
    Car car;

    @ManyToMany()
//            @JoinTable(name="personel_address",joinColumns = @JoinColumn(name="personel_id"),
//                    inverseJoinColumns = @JoinColumn(name="address_id"))
    List<Address> addresses=new ArrayList<>();


    @Override
    public String toString() {
        return "Personel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department.getName() +
                ", car=" + car +
                ", adres=" + addresses +
                '}';
    }
}
