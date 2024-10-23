package com.berre.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="dealers_ship")
public class DealersShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private  String name;
    private String country;

    private String city;

}
