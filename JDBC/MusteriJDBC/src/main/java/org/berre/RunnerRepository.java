package org.berre;

import org.berre.repository.MusteriRepository;
import org.berre.repository.entity.Musteri;

public class RunnerRepository {
    public static void main(String[] args) {
        MusteriRepository repository=new MusteriRepository();
        //repository.save(new Musteri("Arda","Güler","6875412","Erkek",121212154));

        //repository.delete(1003);

        //repository.findAll().forEach(System.out::println);

        System.out.println(repository.findById(1005));

        Musteri m=repository.findById(1005);
        m.setAd("Arda Jrr.");
        m.setSoyad("Güler Jr.");
        m.setTelefon("11112");

        repository.update(m);

        System.out.println(repository.findById(1005));





    }
}
