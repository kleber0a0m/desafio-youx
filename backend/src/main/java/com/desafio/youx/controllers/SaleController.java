package com.desafio.youx.controllers;

import com.desafio.youx.dtos.SaleDto;
import com.desafio.youx.models.ClientModel;
import com.desafio.youx.models.SaleModel;
import com.desafio.youx.services.SaleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) // permitir acesso de qualquer origem

public class SaleController {

        @Autowired
        private SaleService saleService;

        @GetMapping("/sales")//Retorna um JSON com as vendas cadastrados, permite paginação.
        public Page<SaleModel> findSale(Pageable pageable){
            return saleService.findSales(pageable);
        }

        @GetMapping("/sales/findById/{id}")//Retorna um JSON com o cliente de id = {id}
        public ResponseEntity<Object> findById(@PathVariable Long id){
            Optional<SaleModel> saleModel = saleService.findById(id);
            if(saleModel.isPresent()){
                return ResponseEntity.status(HttpStatus.OK).body(saleModel);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venda não encontrada");
        }

        @GetMapping("/sales/find")//Retorna um JSON com o as vendas relacionadas com o Cliente que tenha contenha {search} no nome.
        public Page<SaleModel> findSaleByClient(Pageable pageable, @RequestParam(value = "search")String search){
            return saleService.findSaleByClient(pageable,search);
        }

        @PostMapping("/sales/add")//Adiciona uma venda com base nas informações recebidas.
        public ResponseEntity<Object> saveSale(@RequestBody SaleModel saleModel){
            return ResponseEntity.status(HttpStatus.CREATED).body(saleService.save(saleModel));
        }

        //NÃO ESTÁ FUNCIONANDO COMO ESPERADO =(, NÃO ESTÁ ATUALIZANDO O NADA
        @PutMapping("/sales/update/{id}")//Edita o a venda de id = {id} com base nas informações recebidas.
        public ResponseEntity<Object> updateSale(@PathVariable(value = "id") Long id, @RequestBody @Valid SaleDto saleDto){
            Optional<SaleModel> saleModelOptional = saleService.findById(id);
            if (!saleModelOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venda não encontrads.");
            }
            var saleModel = saleModelOptional.get();
            BeanUtils.copyProperties(saleDto, saleModel);
            return ResponseEntity.status(HttpStatus.OK).body(saleService.save(saleModel));
        }

        @DeleteMapping("/sales/delete/{id}")//Exclui a venda de id = {id}.
        public ResponseEntity<Object> deleteSale(@PathVariable(value = "id") Long id){
            Optional<SaleModel> parkingSpotModelOptional = saleService.findById(id);
            if (!parkingSpotModelOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venda não encontrada.");
            }
            saleService.delete(parkingSpotModelOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Venda deletada com sucesso.");
        }

        @GetMapping("/sales/report")//Retorna um JSON com informações sobre quantidade vendida e o valor por mês.
        public ResponseEntity<Object>report(){
            return ResponseEntity.status(HttpStatus.OK).body(saleService.report());
        }

}
