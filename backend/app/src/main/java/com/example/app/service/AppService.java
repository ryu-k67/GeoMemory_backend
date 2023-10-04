package com.example.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.models.Account;
import com.example.app.repositories.AppRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AppService {
    @Autowired
    AppRepository appRepository;

    public Flux<Account> findAll() {
    return appRepository.findAll();
    }

    public Flux<Account> findByTitleContaining(String title) {
    return appRepository.findByTitleContaining(title);
    }

    public Mono<Account> findById(int id) {
    return appRepository.findById(id);
    }

    public Mono<Account> save(Account account) {
    return appRepository.save(account);
    }

    public boolean isUseridUnique(int userid) {
        return appRepository.existsById(userid);
    }

    public Mono<Account> update(int id, Account app) {
    return appRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
        .flatMap(optionalApp -> {
            if (optionalApp.isPresent()) {
            app.setUserid(id);
            return appRepository.save(app);
            }

            return Mono.empty();
        });
    }

    public Mono<Void> deleteById(int id) {
    return appRepository.deleteById(id);
    }

    public Mono<Void> deleteAll() {
    return appRepository.deleteAll();
    }

    public Flux<Account> findByPublished(boolean isPublished) {
    return appRepository.findByPublished(isPublished);
    }
}
