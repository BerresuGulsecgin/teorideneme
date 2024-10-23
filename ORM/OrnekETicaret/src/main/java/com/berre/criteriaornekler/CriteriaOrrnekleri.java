package com.berre.criteriaornekler;

import com.berre.repository.entity.Musteri;
import com.berre.repository.entity.Urun;
import com.berre.repository.views.VwUrun;
import com.berre.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.List;

public class CriteriaOrrnekleri {
    Session session;
    CriteriaBuilder criteriaBuilder;

    public CriteriaOrrnekleri() {
        session= HibernateUtility.getSessionFactory().openSession();
        criteriaBuilder=session.getCriteriaBuilder();
    }

    /*
    Sorgu 1 : select * from tblmusteri
    geri dönüş tipi -> müşterilerden oluşan bir liste dönecek.
     */

    public List<Musteri> findAll(){
        //Kriter tanımlanırken kullanılacak sınıfın adını vererek işleme başlarız.
        //bu sınıf .class olarak verilmelidir
        //Reflection API sayesinde arka plandda o class içindeki tüm fieldlar belirlenir.
        CriteriaQuery<Musteri> criteriaQuery = criteriaBuilder.createQuery(Musteri.class);

        //Sorgunun atılacağı tabloyu belirleyelim
        Root<Musteri> root = criteriaQuery.from(Musteri.class);

        //Sorguda hangi alanlar seçilecek onu tanımlamalıyız.select içindeki root ifadesi * anlamına gelir.
        criteriaQuery.select(root);

        //Sorgunuz hazır olduktan sonra bunu çalıştırmalısınız
        List<Musteri> resultList = session.createQuery(criteriaQuery).getResultList();

        return resultList;
    }

    /*
    Sorgu 2 : select ad from tblurun
    geri dönüş tipi ->List<String> döner
     */

    public List<String> selectOneColumn(){
        CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<Urun> root = criteriaQuery.from(Urun.class);
        //almak istediğin kolon adını böyle al.şu an ad metodunu seçili hale getirdik
        //root içinde tüm kolonlar vardır ve get ile onların içinden seçim yapılır
        criteriaQuery.select(root.get("ad"));
        List<String> resultList = session.createQuery(criteriaQuery).getResultList();
        return resultList;
    }

    /*
    Sorgu 3 : select ad from tblurun where id=?
    geri dönüş tipi ->String
     */

    public String selectOneColumnById(Long idparametre){
        CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class); //geri dönüş tipi
        Root<Urun> root = criteriaQuery.from(Urun.class); //from tblurun
        criteriaQuery.select(root.get("ad"));  //select ad

        //Predicate bir koşul oluşturma  işlemidir.
        //where sorgusu bir veya birden çok predicate bekler
        //Koşulunuzu predicate olarak oluşturup where sorgusuna aktarmalısınız
        //= equals, > greaterThan, gibi metodlar kullanılır.
        Predicate p1=criteriaBuilder.equal(root.get("id"),idparametre); //id=idparametre
        criteriaQuery.where(p1); //where
        //criteriaQuery.select(root.get("ad")).where(p1); ile tek satır da yazılabilir

        String singleResult = session.createQuery(criteriaQuery).getSingleResult();//tek kayıt döneceği için
        return singleResult;
    }

    /*
    Sorgu 4 : select * from tblurun where id=?
    geri dönüş tipi ->Urun
     */
    public Urun findUrunById(Long idparametre){
        CriteriaQuery<Urun> criteriaQuery = criteriaBuilder.createQuery(Urun.class); //geri dönüş tipi
        Root<Urun> root = criteriaQuery.from(Urun.class); //from tblurun
        Predicate p1=criteriaBuilder.equal(root.get("id"),idparametre); //id=idparametre
        criteriaQuery.select(root).where(p1);
        Urun singleResult = session.createQuery(criteriaQuery).getSingleResult();//tek kayıt döneceği için
        return singleResult;
    }

    /*
    Sorgu 5 : select id, ad, fiyat from tblurun
    geri dönüş tipi -> Object[] veya tuple kullanılabilir
     */

    public List<Object[]>  selectManyColumn(){
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Urun> root = criteriaQuery.from(Urun.class);

        //birden çok alan gelecekse path ile işlem yapılmalıdır
        Path<Long> pathId=root.get("id");
        Path<String> pathAd=root.get("ad");
        Path<BigDecimal> pathFiyat=root.get("fiyat");

        //criteriaQuery.select(criteriaBuilder.array(pathId,pathAd,pathFiyat));
        //üstteki satırın alternatifi multiselect tir
        criteriaQuery.multiselect(pathId,pathAd,pathFiyat);

        List<Object[]> resultList = session.createQuery(criteriaQuery).getResultList();
        return resultList;

    }

    /*
    Sorgu 6 : select * from tblurun where ad like'%?' and  fiyat>?
    geri dönüş tipi ->List<Urun>
     */

    public List<Urun> findAllByNameAndFiyatGt(String urunAd, BigDecimal fiyat){
        CriteriaQuery<Urun> criteriaQuery = criteriaBuilder.createQuery(Urun.class);
        Root<Urun> root = criteriaQuery.from(Urun.class);
        Predicate p1=criteriaBuilder.like(root.get("ad"),urunAd); //ad like'%?'
        Predicate p2=criteriaBuilder.greaterThan(root.get("fiyat"),fiyat); //fiyat>?
        Predicate sonKosul=criteriaBuilder.and(p1,p2); //ad like'%?' and  fiyat>?
        criteriaQuery.select(root).where(sonKosul);
        return session.createQuery(criteriaQuery).getResultList();
    }

    /**
     * Native Query yazımı : SQL kodları ile JPA üzerinden sorgulama yapmak
     *
     * Eğer direkt sorguyu yazıp bırakırsanız geriye Object dizisi döner
     * Gidip belirtmek grekli
     */

    public List<Urun> findAllNativeQuery(){
        List<Urun> resultList = session.createNativeQuery("select * from tblurun",Urun.class).getResultList();


        return resultList;
    }

    public List<VwUrun> findAllNativeQuery2(){
        List<VwUrun> resultList = session.createNativeQuery("select id,ad from tblurun", VwUrun.class).getResultList();
        return resultList;
    }

    /**
     * Named Query
     * Kullanılacak dil : JPQL, HQL
     * Entitiy üzerine yazılır
     *
     * SQL  -> select * from tblmusteri
     * JPQL -> select m from Musteri m
     * HQL  -> from Musteri
     */

    public List<Urun> findAllNamedQuery(){
        Query<Urun> namedQuery = session.createNamedQuery("Urun.findAll", Urun.class);
        return namedQuery.getResultList();
        //return session.createNamedQuery("Urun.findAll", Urun.class).getResultList();
    }


    public List<Urun> findAllByAd(String urunAdi){
        Query<Urun> namedQuery = session.createNamedQuery("Urun.findByAd", Urun.class);
        namedQuery.setParameter("urunad",urunAdi);
        return namedQuery.getResultList();
    }
}
