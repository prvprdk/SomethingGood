package com.example.somethinggood.service;

import com.example.somethinggood.domain.GoodMessage;
import com.example.somethinggood.repository.GoodMessageRepository;
import com.example.somethinggood.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private GoodMessageRepository goodMessageRepository;
    @Autowired
    private UserRepo userRepo;


    public GoodMessage getMessageRandom(Long id) {
        return goodMessageRepository.getRandomMessage(id);
    }

    public void save(GoodMessage message) {
        goodMessageRepository.save(message);
    }
}
