package com.thanhhanh.beta.service;

import com.thanhhanh.beta.entity.Book;
import com.thanhhanh.beta.model.ResponseData;
import com.thanhhanh.beta.repository.BookRepository;
import com.thanhhanh.beta.repository.UserRepository;
import com.thanhhanh.beta.request.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    public ResponseData<Book> bookTicket(Authentication authentication, BookRequest bookRequest){
        Integer userId = userRepository.findIdByUsername(authentication.getName());
        if(bookRequest == null){
            return new ResponseData(HttpStatus.FOUND, "book ticket fail", null);
        }else{
            return new ResponseData(HttpStatus.OK, "success", bookRepository.bookTicket(userId, bookRequest.getScheduleId(), bookRequest.getSeatId(), bookRequest.getPrice(), bookRequest.getSeatStatus()));
        }
    }

    public ResponseData<Integer> updateStatus(Authentication authentication, Integer book_id){
            Integer userId = userRepository.findIdByUsername(authentication.getName());
            return new ResponseData(HttpStatus.OK, "book running", bookRepository.updateStatus(userId, book_id));
    }

}
