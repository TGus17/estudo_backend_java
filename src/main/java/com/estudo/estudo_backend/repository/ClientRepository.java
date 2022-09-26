package com.estudo.estudo_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.estudo.estudo_backend.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
  
}
