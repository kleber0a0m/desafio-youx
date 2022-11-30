package com.desafio.youx.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_CLIENT")
public class ClientModel  implements Serializable {

    //Define que o id do Cliente vai se a variavel id
    @Id
    //O id vai ser auto increment
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    /* cpnj será salvo com tamanho de 14 sem ponto(.), barra(/) e traço(-)
    ex: 12.345.678/9012-34 -> 12345678901234
    Se fosse int um cnpj que inicie com 0 poderia dar problema. por isso a escolha por String
     */
    @Column(nullable = false,length = 14)
    private String cnpj;

    //Tamanho maximo de email é de 256 de acordo com a RFC 5321 (seção 4.5.3)
    @Column(nullable = false,length = 256)
    private String email;

    /*Telefone com tamanho 11, deconsiderando código do pais e considerando ddd o número 9 extra,
    sem espaços e () e traços. ex (35) 9 0000-0000 -> 35900000000*/
    @Column(nullable = false,length = 11)
    private String phone;

    //UF com tamanho 2 ex: MG
    @Column(nullable = false,length = 2)
    private String uf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
