package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;
//Mapear a classe ORDER
@Entity
//Vai customizar o nome da tabela do banco de dados
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    private OrderStatus status;

    //Vai adicionar o campo client_id na tabela tb_order que é chave estrangeira
    //Muitos pedidos para um usuario
    @ManyToOne
    //Definindo a classe estrangeira da tabela TB_USER da classer User
    @JoinColumn(name = "client_id")
    private User client;

    //nome do atributo que está no payment e cascadeType.ALL para funcionar corretamente OneToOne
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private  Payment payment;

    public Order(){

    }

    public Order(Long id, Instant moment, OrderStatus status, User client, Payment payment) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
