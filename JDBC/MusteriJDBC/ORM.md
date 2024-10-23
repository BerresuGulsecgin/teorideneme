# ORM NEDİR?
## Object Relational Mapping : Nesne - İlişkisel Eşleştirme

OOP dillerle veritabanı arasındaki farklı yapıları eşleştirmekte kullanılan bir tekniktir.
ORM ile vt içindeki tablolar nesneler ile ilişkilendirilir.
Böylece vt işlemlerini nesne odaklı bir şekilde yapabiliriz.

ORM kullansakta yine Driver'e ihtiyacımız olacak.

Nesneler aracılığıya veri tabanındaki tablolara;
* eklemee
* silme
* güncelleme
* tablolar arası ilişkiler
    * one to one
    * one to many
    * many to one
    * many to many
* PK, Sequance

PostgreSQL de tek yapacağınız şey veri tabanı açmak

ORM araçları ile siz kolayca vt değiştirebilirsiniz.VT bağımsıızlığı kazandırır.

### Avantajları
* Yazılım geliştirme sürecimizi kısaltır
* VT sorguları ilee ilgili detaylarla siz uğraçmak zorunda kalmazsınız

### Dezavantajları
* Performansı JDBC den bir tık yavaştır
* Öğrenme eğrisi karmaşık.
* Arka planda karmasık bir yapısı var.

### JPA : Java Persistance API -> Jakarta Persistance API
JDO, JBAF

## ORM Araçları;
* Hibernate (Java için en popüler ORM aracı)
* EclipseLine
* OpenJPA




| JDBC                                 | Hibernate                                                     |
|--------------------------------------|---------------------------------------------------------------|
| Low-Level SQL komutları              | Arka planda JDBC kullanır ve sizi o katmandan soyutlar        |
| SQL                                  | SQL + HQL + JPQL                                              |
| Nesne-Tablo ilişkiyi Manuel yapar    | Otomatik yapılır                                              |
| Veri tabanına direkt olarak bağlanır | Veri tabanı bağlılığını ortadan kaldırır                      |
| Cachleme yok                         | Cach yapısı var                                               |
| Kodlar SQL ile karmaşıklaşabilir     | Çok daha basit soruglar yazılabilir.Veya metodları kullanılır |


## ORM Aracı (Hibernate)
* Sen bana bilgileri ver(AdresBilgisi, port bilgisi, vt bilgisi, username ve password)
* Ben bağlantı kurarım
* Bütün temel işlemlerrini yapacak hazır metodlarımı kullanabilirsin
* Bu yüzden Hibernate için yapılandırma dosyaları çok önemlidir.
* list()

Hibernate 6 sürümünden önce JPA(Java Persistance API) kullanır.
6 sürümü ve üzerinde JPA(Jakarta Persistance API) kullanılır.

API : Application Programin Interface

### Javada direkt olarak JPA kullanılabilir mi?
Hayır interface direkt kullanamazsın.
