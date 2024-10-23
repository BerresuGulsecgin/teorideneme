package com.berre.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="tbl_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    //birden çok personel olacağı için
    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    //@Fetch(FetchMode.JOIN) yukarıdaki eagerin alternatifi
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})

    List<Personel> personelList=new ArrayList<>();

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", personelList=" + personelList +
                '}';
    }
}
