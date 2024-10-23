package com.berre;

import com.berre.repository.entity.Musteri;
import com.berre.utility.HibernateUtility;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session= HibernateUtility.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
//        Musteri m1=new Musteri("Berre","Gül","Dublin");
//        Kaydetme
//        session.save(m1);
//        m1.setAd("Deneme10");


//        Güncelleme
//        Musteri m1=new Musteri(6,"Deneme2","Celik","Paris");
//        session.update(m1);

//        2.yol daha doğru
//        Musteri arananMusteri=session.get(Musteri.class, 6); //veri tabanında arama yapıp  bulduğunu döner
//        arananMusteri.setAdres("Yozgat"); //nesneden istediğin güncellemeyi set ile yap
//        arananMusteri.setSoyad("Yoz");
//        session.update(arananMusteri); //update metoduna değişen nesneyi yolla


//        Silme
//        Musteri silinecekMusteri=session.get(Musteri.class, 6);
//        session.delete(silinecekMusteri);


        //Sorgulama koşul yoksa
        Criteria criteria=session.createCriteria(Musteri.class); //Geri dönecek tipi içine ver
        List<Musteri> musteriList= criteria.list();


        transaction.commit();
        session.close();

        musteriList.forEach(System.out::println);
    }
}