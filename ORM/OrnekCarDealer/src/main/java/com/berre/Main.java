package com.berre;

import com.berre.entity.Car;
import com.berre.entity.DealersShip;
import com.berre.repository.CarRepository;
import com.berre.repository.DealersShipRepository;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        CarRepository carRepository=new CarRepository();
        Car car=Car.builder()
                .id(3L)
                .carModel("Kia")
                .brand("Rio")
                .modelYear("2021")
                .build();
        //carRepository.save(car);

        DealersShipRepository dealersShipRepository=new DealersShipRepository();
        DealersShip dealersShip=DealersShip.builder()
                .name("Bahadır")
                .country("USA")
                .city("ank")
                .build();

        //carRepository.update(car);
        //dealersShipRepository.save(dealersShip);
        //carRepository.delete(car);

        //carRepository.deleteById(2L);

        //carRepository.findById(2L);

        //carRepository.findByColumnNameAndValue("carModel","Ford").forEach(System.out::println);

        //carRepository.findByEntity(car).forEach(System.out::println);

        //carRepository.findAll().forEach(System.out::println);


    }
}