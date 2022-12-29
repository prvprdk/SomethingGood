package com.example.somethinggood.service;

import com.example.somethinggood.domain.User;
import com.example.somethinggood.repository.GoodMessageRepository;
import com.example.somethinggood.domain.GoodMessage;
import com.example.somethinggood.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private GoodMessageRepository goodMessageRepository;
    @Autowired
    private UserRepo userRepo;

    public List<GoodMessage> sortGoodMessageUser(User user) {


        List <GoodMessage> sort = goodMessageRepository.findByAuthorNot(user);
        return sort;
    }

    public GoodMessage randomMessage(List<GoodMessage> sortGoodMessageUser) {
        int amountOfRecord = sortGoodMessageUser.size()-1;
        int randomRecord = (int) (Math.random() * (amountOfRecord) + 0);
        return sortGoodMessageUser.get(randomRecord);

    }
}
