package com.example.app.repositories;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.example.app.models.Account;

import reactor.core.publisher.Flux;

@Repository
public interface AppRepository extends R2dbcRepository<Account, Integer>{
  Flux<Account> findByTitleContaining(String title);
  
  Flux<Account> findByPublished(boolean isPublished);

  boolean existsById(int userId);
}