package com.desafio.youx.repositories;

import com.desafio.youx.models.ClientModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel,Long> {
    boolean existsByCnpj(String cnpj);

    //Pesquisa o conteudo de search nas colunas nome ou cnpj
    @Query("SELECT c FROM ClientModel c WHERE UPPER(c.cnpj) LIKE %:search% OR UPPER(c.name) LIKE %:search%")
    Page<ClientModel> findByCnpjOrName(Pageable pageable,@Param("search") String search);
}
