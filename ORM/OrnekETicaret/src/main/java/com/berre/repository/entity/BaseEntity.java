package com.berre.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BaseEntity {

    /**
     * Tarih ve zaman damgası için genellikle Long veri türünü tavsiye ederiz.Zamanı ms cinsinden tutar(Epoch Time)
     */
    Long olusturmaTarihi;
    Long guncellemeTarihi;
    Integer durum;
}
