package com.berre.repository.entity;

/*
* Hibernate içinde bir çok configirasyon  @ anatasyonlarla yapıldığı için bunların neler oldıuğu ve ne işe yaradığı çok önemlidir
* @Entity : Bu sınıfın varlık sınıfı olduğunu belirtir.ORM aracı buradan bir tablo oluşturu
* @Table: üzerine eklendiği sınıfın databasedeki özelliklerini düzenlemek için kullanılır
*       her tablo için bir isim verilmesi önerilidr.Eğer verilmezse tablo adı clas adı olarak verilir.
*@Id : üzerinde bulunduğu alanı tabloda PK yapar
* @@GeneratedValue(strategy = GenerationType.IDENTITY) : sequance oluşturur.Serial gibi düşünülebilir.

 */

import com.berre.enums.ECinsiyet;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tblmusteri")
public class Musteri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //Long ile long arasındaki fark nedir?
    //Long : default değeri -> Null(wrapper)
    //long : default değeri -> 0 (primitive)

    @Column(name="musteriad",  //tablodaki kolon adını düzenler
           length = 30, //kolonun boyutunu belirler
            nullable = false, // null değeri alıp alamayacağı.False boş geçilemez, true boş geçilebilir
            unique = false, //bu alanın benzersiz olmasını istersek true yapılır
            insertable = true, //bu alanın ekleme sorgusunda bulunmasına karar verir.
            updatable = false // sonradan güncellenmesine izin vermez.
    )
    String ad;

    String soyad;

    /**
     * Bir kullanıcıcn birden çok telefon numarasını tutmak için list türünü kullanabiliriz.
     * Ancak List gibi collection türlerini @Entity ile işaretlenmiş sınıfta tutmak istersek hata alırız
     * Bu türün mutlaka @ElementCollection ile işarelenmesi gerekir
     * VT de Telefon ve müşteriyi eşleyerek yeni bir tablo oluşturup tutarr
     * Bu anatasyon ile işaretlenen alan için ayrı bir tablo oluşturulur.
     */
    @ElementCollection
    List<String> telefon;




    /**
     * Zaman tanımlama için  @Temporal kullanılır
     * TemporalType.DATE -> sadece tarih bilgisini
     * TemporalType.TIME -> sadece saat bilgisi
     * TemporalType.TIMESTAMP -> hem tarih hem zaman bilgisini tutmak için
     */
    @Temporal(TemporalType.DATE)
    Date dogumTarihi;
    @Temporal(TemporalType.TIME)
    Date iseGirisTarihi;
    @Temporal(TemporalType.TIMESTAMP)
    Date kayitTarihi;



    /**
     * VT de kolon olarak tutulmasını istemediğimiz alanları  @Transient ile işaretleriz
     */
    @Transient
    String adsoyad;

    /**
     * Enum bilgiler 2 alandan oluşur.
     * Enum değeri inttir.Görünen değeri Stringtir.
     * Hangi değerin vt ye kaydedileceği burada belirtilebilir
     * EnumType.ORDINAL ya da  EnumType.STRING
     */
    @Enumerated(EnumType.ORDINAL)
    ECinsiyet cinsiyet;

    @Embedded
    BaseEntity baseEntity;

    @Embedded
    Iletisim iletisim;

}
