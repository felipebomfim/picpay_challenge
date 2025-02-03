package com.picpay_challenge.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.picpay_challenge.domain.user.User;
import com.picpay_challenge.domain.user.UserType;
import com.picpay_challenge.repositories.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateTransaction(User sender, BigDecimal amount) throws Exception{
        if (sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuário do tipo Lojista não está autorizado a realizar transação.");
        }

        if (sender.getBalance().compareTo(amount) < 0){

            throw new Exception("Saldo insuficiente!");
        }
    }

    public User findUserById(Long id) throws Exception{
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado."));
    }

    public void saveUser(User user){
        this.userRepository.save(user);
    }
}
