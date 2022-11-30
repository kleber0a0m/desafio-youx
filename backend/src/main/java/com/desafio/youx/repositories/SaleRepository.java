package com.desafio.youx.repositories;

import com.desafio.youx.models.SaleModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<SaleModel,Long> {
    //Retorna a soma de todas as vendas no ano atual
    @Query("SELECT sum(s.saleValue) FROM SaleModel s WHERE YEAR(s.date) = :year")
    String currentYearSold(@Param("year") int year);

    //Relatorios de faturamento por mês
    @Query("SELECT sum(s.saleValue) from SaleModel s WHERE MONTH(s.date) = 1")
    Double januaryTotalSold();
    @Query("SELECT count(s.id) from SaleModel s WHERE MONTH(s.date) = 1")
    Integer januaryQuantitySold();
    @Query("SELECT sum(s.saleValue) from SaleModel s WHERE MONTH(s.date) = 2")
    Double februaryTotalSold();
    @Query("SELECT count(s.id) from SaleModel s WHERE MONTH(s.date) = 2")
    Integer februaryQuantitySold();
    @Query("SELECT sum(s.saleValue) from SaleModel s WHERE MONTH(s.date) = 3")
    Double marchTotalSold();
    @Query("SELECT count(s.id) from SaleModel s WHERE MONTH(s.date) = 3")
    Integer marchQuantitySold();
    @Query("SELECT sum(s.saleValue) from SaleModel s WHERE MONTH(s.date) = 4")
    Double aprilTotalSold();
    @Query("SELECT count(s.id) from SaleModel s WHERE MONTH(s.date) = 4")
    Integer aprilQuantitySold();
    @Query("SELECT sum(s.saleValue) from SaleModel s WHERE MONTH(s.date) = 5")
    Double mayTotalSold();
    @Query("SELECT count(s.id) from SaleModel s WHERE MONTH(s.date) = 5")
    Integer mayQuantitySold();
    @Query("SELECT sum(s.saleValue) from SaleModel s WHERE MONTH(s.date) = 6")
    Double juneTotalSold();
    @Query("SELECT count(s.id) from SaleModel s WHERE MONTH(s.date) = 6")
    Integer juneQuantitySold();
    @Query("SELECT sum(s.saleValue) from SaleModel s WHERE MONTH(s.date) = 7")
    Double julyTotalSold();
    @Query("SELECT count(s.id) from SaleModel s WHERE MONTH(s.date) = 7")
    Integer julyQuantitySold();
    @Query("SELECT sum(s.saleValue) from SaleModel s WHERE MONTH(s.date) = 8")
    Double augustTotalSold();
    @Query("SELECT count(s.id) from SaleModel s WHERE MONTH(s.date) = 8")
    Integer augustQuantitySold();
    @Query("SELECT sum(s.saleValue) from SaleModel s WHERE MONTH(s.date) = 9")
    Double septemberTotalSold();
    @Query("SELECT count(s.id) from SaleModel s WHERE MONTH(s.date) = 9")
    Integer septemberQuantitySold();
    @Query("SELECT sum(s.saleValue) from SaleModel s WHERE MONTH(s.date) = 10")
    Double octoberTotalSold();
    @Query("SELECT count(s.id) from SaleModel s WHERE MONTH(s.date) = 10")
    Integer octoberQuantitySold();
    @Query("SELECT sum(s.saleValue) from SaleModel s WHERE MONTH(s.date) = 11")
    Double novemberTotalSold();
    @Query("SELECT count(s.id) from SaleModel s WHERE MONTH(s.date) = 11")
    Integer novemberQuantitySold();

    @Query("SELECT sum(s.saleValue) from SaleModel s WHERE MONTH(s.date) = 12")
    Double decemberTotalSold();
    @Query("SELECT count(s.id) from SaleModel s WHERE MONTH(s.date) = 12")
    Integer decemberQuantitySold();

    @Query("SELECT s FROM SaleModel s WHERE UPPER(s.client.name) LIKE %:search%")
    Page<SaleModel> findSaleByClient(Pageable pageable, String search);
}
