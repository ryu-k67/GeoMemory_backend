package com.example.app.controller;

//import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.models.Account;
import com.example.app.service.AppService;

//import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AppController {
    @Autowired
    AppService appService;

    //@GetMapping("/apps")
    //@ResponseStatus(HttpStatus.OK)
    //public Flux<Account> getAllTutorials(@RequestParam(required = false) String title) {
    //if (title == null)
    //    return appService.findAll();
    //else
    //    return appService.findByTitleContaining(title);
    //}

    //このGetメソッドはポストマンで機能した
    @GetMapping("/apps/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Account> getTutorialById(@PathVariable("id") int id) {
    return appService.findById(id);
    }

    @GetMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Integer> signin(@RequestBody Account account) {
        return appService.signin(account);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Integer> signup(@RequestBody Account account) {
        return appService.regist(account);
    }

    //@PostMapping("/accountSignup")
    //@ResponseStatus(HttpStatus.CREATED)
    //public Mono<Account> accountSignup(@RequestBody Account account) {
    //    Random random = new Random();
    //    final Integer[] userid = {random.nextInt()}; // 配列でラップ
    //    //useridを正の値にする
    //    if(userid[0] < 0){
    //        userid[0] *= -1;
    //    }
    //
    //    //useridが一意であることを確認して、アカウントの登録を行う
    //    return appService.isUseridUnique(userid[0])
    //    .flatMap(isUnique -> {
    //        if (isUnique == false) {
    //            // ユーザーIDが一意の場合
    //            account.setUserid(userid[0]);
    //            return appService.save(account);
    //            //account.setUserid(userid[0]);
    //            //return appService.update(userid[0], account);
    //        } else {
    //            // ユーザーIDが一意でない場合
    //            return accountSignup(account); // 再帰呼び出し
    //        }
    //    });
    //}

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

    //@GetMapping("/apps/published")
    //@ResponseStatus(HttpStatus.OK)
    //public Flux<Account> findByPublished() {
    //return appService.findByPublished(true);
    //}
}