package com.example.app.service;

import java.util.Optional;
//import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
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

    //public Flux<Account> findByTitleContaining(String title) {
    //return appRepository.findByTitleContaining(title);
    //}

    public Mono<Account> findById(int id) {
    return appRepository.findById(id);
    }

    public Mono<Account> save(Account account) {
    return appRepository.save(account);
    }

    //public Mono<Boolean> isUseridUnique(Integer[] userid) {
    //    return appRepository.existsById(userid);
    //}

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

    //public Flux<Account> findByPublished(boolean isPublished) {
    // return appRepository.findByPublished(isPublished);
    //}

    public Mono<Integer> regist(Account accountInfo){
        var account = new Account();
        account.setMailaddress(accountInfo.getMailaddress());
        account.setPassword(accountInfo.getPassword());

        return save(account)
        .map(savedAccount -> savedAccount.getUserid())
        .onErrorReturn(-1);
    }

    //public Mono<Account> regist(Account accountInfo){
    //    var account = new Account();
    //    account.setMailaddress(accountInfo.getMailaddress());
    //    account.setPassword(accountInfo.getPassword());
    //
    //  //useridの生成
    //    Random random = new Random();
    //    final Integer[] userid = {random.nextInt()}; // 配列でラップ
    //    //useridを正の値にする
    //    if(userid[0] < 0){
    //        userid[0] *= -1;
    //    }
    //
    //    //useridが一意であることを確認して、アカウントの登録を行う
    //    return appRepository.existsById(userid[0])
    //    .flatMap(isUnique -> {
    ////        if (isUnique == false) {
    //            // ユーザーIDが一意の場合
    //            //account.setUserid(userid[0]);
    //            return save(account);
    //            //account.setUserid(userid[0]);
    //            //return appService.update(userid[0], account);
    //        } else {
    //            // ユーザーIDが一意でない場合
    //            return regist(accountInfo); // 再帰呼び出し
    //        }
    //    });
    //}
}
