package com.desafio.youx.dtos;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClientDto {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(min = 14, max = 14)
    private String cnpj;

    @NotBlank
    @Size(max = 256)
    private String email;

    @NotBlank
    @Size(min = 10, max = 11)
    private String phone;

    @NotBlank
    @Size(min = 2, max = 2)
    private String uf;

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
