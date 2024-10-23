# Hibernate ile adım adım proje oluşturma 

1. Veritabanı sunucusunda bir veritabanı oluştur.(Java12OrnekETicaret)
2. Package oluşturalım.(entity, utility)
3. Resources içine config dosyasını at
4. hibernate.cfg.xml de gerekli değişikliği yap
5. build.gradle dosyasına dependencies  ekle.
6. gerekli entitiyleri ekle.(Sepet, Urun)
7. Entitiyler için
    1. boş constuructor
   2. id siz dolu constuructor
   3. dolu constuructor
   4. getter seter
   5. toString
8. hibernate.cfg.xml de mapping işlemini yap
9. Utilty peckage içine HibernateUtility.java dosyasını ekle


# Kullanma Adımları
1. Session oluştur;
    1. Session session= HibernateUtility.getSessionFactory().openSession();
    2. session.close();
2. Transaction oluştur ve başlat;
    1. Transaction transaction=session.beginTransaction();
    2. transaction.commit(); 
3. CRUD işlemlerini yap


# Lombok kullanılan anatasyonlar
1. @NoArgsConstructor // boş constuctor
2. @AllArgsConstructor // dolu constuructor
3. @Data  //getter/setter/toString
 
