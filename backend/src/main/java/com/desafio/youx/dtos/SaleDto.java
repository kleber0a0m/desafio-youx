package com.desafio.youx.dtos;
import com.desafio.youx.models.ClientModel;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class SaleDto {

    private ClientModel client;

    private LocalDate date;

    private String situation;

    private Double saleValue;
}
