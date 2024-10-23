package com.berre;

import com.berre.criteriaornekler.CriteriaOrrnekleri;
import com.berre.enums.ECinsiyet;
import com.berre.repository.UrunRepository;
import com.berre.repository.entity.*;
import com.berre.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

//        Urun urunLaptop=Urun.builder()
//                .ad("Laptop")
//                .fiyat(BigDecimal.valueOf(50000))
//                .stok(5)
//                .build();
//
//        new UrunRepository().save(urunLaptop);

       // new UrunRepository().deleteById(5L);

        CriteriaOrrnekleri criteriaOrrnekleri=new CriteriaOrrnekleri();
        //criteriaOrrnekleri.findAllNativeQuery2().forEach(System.out::println);
        //criteriaOrrnekleri.findAll().forEach(System.out::println);
        //criteriaOrrnekleri.findAllNamedQuery().forEach(System.out::println);
        criteriaOrrnekleri.findAllByAd("Bilgi%").forEach(System.out::println);

        //criteriaOrrnekleri.selectOneColumn().forEach(System.out::println);
        //String donenAd =criteriaOrrnekleri.selectOneColumnById(2L);
        //System.out.println(donenAd);

        //Urun donenUrun =criteriaOrrnekleri.findUrunById(2L);
        //System.out.println(donenUrun);

//        criteriaOrrnekleri.selectManyColumn().forEach(o->{
//            System.out.println("id: "+o[0]);
//            System.out.println("ad: "+o[1]);
//            System.out.println("fiyat: "+((BigDecimal)o[2]).multiply(BigDecimal.valueOf(1.18))  );
//        });

//        criteriaOrrnekleri.findAllByNameAndFiyatGt("%r%", BigDecimal.valueOf(15)).forEach(System.out::println);

//        Session session= HibernateUtility.getSessionFactory().openSession();
//        Transaction transaction=session.beginTransaction();
//
//        session.save(new Urun("Un", 50));
//
//         transaction.commit();
//         session.close();

//        Session session;
//        Transaction transaction;
//
//        BaseEntity baseEntity= BaseEntity.builder()
//                .durum(1)
//                .olusturmaTarihi(System.currentTimeMillis())
//                .guncellemeTarihi(System.currentTimeMillis())
//                .build();
//
//        Urun urunBilgisayar=Urun.builder()
//                .ad("Bilgisayar")
//                .fiyat(BigDecimal.valueOf(20))
//                .stok(100)
//                .baseEntity(baseEntity)
//                .build();

        //UrunRepository urunRepository=new UrunRepository();
        //urunRepository.save(urunBilgisayar);

        //yukarıdakinin yerine tek satır da yazılabilir
        //new UrunRepository().save(urunBilgisayar);

//        Urun urunUn=Urun.builder()
//                .ad("Un")
//                .fiyat(BigDecimal.valueOf(40))
//                .stok(100)
//                .baseEntity(baseEntity)
//                .build();



//
//        session= HibernateUtility.getSessionFactory().openSession(); //bağlantı açıldı
//        transaction=session.beginTransaction();  //trqnsaction başlatıldı

//        session.save(urunSeker);
//        session.save(urunUn);
//
//        Satis satis=Satis.builder()
//                .musteriid(1L)
//                .tarih(System.currentTimeMillis())
//                .baseEntity(baseEntity)
//                .toplamTutar(BigDecimal.valueOf(500))
//                .build();
//
//        session.save(satis);
//
//        SatisDetay satisDetaySeker=SatisDetay.builder()
//                .urunid(1L)
//                .fiyat(BigDecimal.valueOf(20))
//                .adet(5)
//                .toplamFiyat(BigDecimal.valueOf(100))
//                .baseEntity(baseEntity)
//                .satisid(1L)
//                .build();



//        SatisDetay satisDetayUn=SatisDetay.builder()
//                .urunid(2L)
//                .fiyat(BigDecimal.valueOf(40))
//                .adet(10)
//                .toplamFiyat(BigDecimal.valueOf(400))
//                .baseEntity(baseEntity)
//                .satisid(1L)
//                .build();

        //session.save(satisDetaySeker);
        //session.save(satisDetayUn);



        //session.save(m1); //kayıt işlemi yapılıdı

//        Musteri aranan=session.get(Musteri.class,2L);
//        aranan.setAd("Tarkan");
//        session.update(aranan);

//        Musteri silinecek=session.get(Musteri.class, 2L);
//        session.delete(silinecek);



       // transaction.commit(); //işlemi onayladık
       // session.close(); //bağlantıyı kapattık



    }
}