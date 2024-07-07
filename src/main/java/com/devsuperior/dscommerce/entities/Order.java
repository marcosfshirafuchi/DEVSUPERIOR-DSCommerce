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
}
