package com.berre;

import com.berre.repository.AddressRepository;
import com.berre.repository.CarRepository;
import com.berre.repository.DepartmentRepository;
import com.berre.repository.PersonelRepository;
import com.berre.repository.entity.Address;
import com.berre.repository.entity.Car;
import com.berre.repository.entity.Department;
import com.berre.repository.entity.Personel;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        //Department oluşturup kaydedelim
        DepartmentRepository departmentRepository=new DepartmentRepository();
        PersonelRepository personelRepository=new PersonelRepository();
        CarRepository carRepository=new CarRepository();
        AddressRepository addressRepository=new AddressRepository();


        Department departmentSatis=Department.builder()
                .name("Satış Departmanı")
                .build();
        Department departmentMuhasebe=Department.builder()
                .name("Muhasebe Departmanı")
                .build();

//        departmentRepository.save(departmentSatis);
//        departmentRepository.save(departmentMuhasebe);

        Car carAudi=Car.builder()
                .make("AUDI")
                .model("A8")
                .plate("34AUD001")
                .build();
        Car carBmw=Car.builder()
                .make("MBW")
                .model("i8")
                .plate("34BMW555")
                .build();

        Address addressEv=Address.builder()
                .city("istanbul")
                .street("galata")
                .build();
        Address addressIs=Address.builder()
                .city("Londra")
                .street("Baker")
                .build();
        Address addressYazlik=Address.builder()
                .city("antalya")
                .street("alanya")
                .build();

        addressRepository.saveAll(List.of(addressEv,addressIs,addressYazlik));


        //Personelleri oluşturlarım.Departman da verip kaydet
        Personel p1=Personel.builder()
                .name("Hakan")
                .department(departmentSatis)
                .age(35)
                .addresses(List.of(addressEv,addressIs))
                .car(carAudi)
                .build();
        Personel p2=Personel.builder()
                .name("Can")
                .department(departmentSatis)
                .car(carBmw)
                .addresses(List.of(addressEv))
                .age(30)
                .build();
        Personel p3=Personel.builder()
                .name("Bilge")
                .addresses(List.of(addressYazlik))
                .department(departmentMuhasebe)
                .age(40)
                .build();

        departmentSatis.setPersonelList(List.of(p1,p2));
        departmentMuhasebe.setPersonelList(List.of(p3));

//        departmentRepository.save(departmentSatis);
//        departmentRepository.save(departmentMuhasebe);

        personelRepository.saveAll(List.of(p1,p2,p3));

        //personelRepository.deleteById(1L);
        //departmentRepository.deleteById(1L);
        //departmentRepository.findAll().forEach(System.out::println);

        //personelRepository.findAll().forEach(System.out::println);
        //carRepository.findAll().forEach(System.out::println);

        //personelRepository.deleteById(1L);

        //addressRepository.findAll().forEach(System.out::println);

        //addressRepository.deleteById(3L);





//        Car carMercedes=Car.builder()
//                .make("Mercedes")
//                .model("s450")
//                .plate("34MRC500")
//                .build();
//        carRepository.save(carMercedes);
//        carRepository.deleteById(3L);








    }
}