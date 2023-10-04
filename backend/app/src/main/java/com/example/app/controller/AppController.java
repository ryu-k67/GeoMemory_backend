package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.models.Account;
import com.example.app.service.AppService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AppController {
    @Autowired
    AppService appService;

    @GetMapping("/apps")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Account> getAllTutorials(@RequestParam(required = false) String title) {
    if (title == null)
        return appService.findAll();
    else
        return appService.findByTitleContaining(title);
    }

    @GetMapping("/apps/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Account> getTutorialById(@PathVariable("id") int id) {
    return appService.findById(id);
    }
    //サインアップ時にアカウント情報を登録する
    @PostMapping("/accountSignup")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Account> createAccount(@RequestBody Account account) {
        account.userid = appService.createUserid();
        return appService.save(account);
    }

    @PutMapping("/apps/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Account> updateTutorial(@PathVariable("id") int id, @RequestBody Account app) {
    return appService.update(id, app);
    }

    @DeleteMapping("/apps/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteTutorial(@PathVariable("id") int id) {
    return appService.deleteById(id);
    }

    @DeleteMapping("/apps")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAllTutorials() {
    return appService.deleteAll();
    }

    @GetMapping("/apps/published")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Account> findByPublished() {
    return appService.findByPublished(true);
    }
}