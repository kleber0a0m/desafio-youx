package com.desafio.youx.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "TB_SALE")
public class SaleModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne//Relacionamento muitos(vendas) para um (Cliente)
    @JoinColumn(name = "client_id")

    private ClientModel client;

    private LocalDate date;

    private String situation;

    private Double saleValue;

    public SaleModel() {
    }

    public SaleModel(Long id, ClientModel client, LocalDate date, String situation, Double saleValue) {
        this.id = id;
        this.client = client;
        this.date = date;
        this.situation = situation;
        this.saleValue = saleValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public Double getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(Double saleValue) {
        this.saleValue = saleValue;
    }
}
