package com.thanhhanh.beta.service;

import com.thanhhanh.beta.entity.Book;
import com.thanhhanh.beta.model.ResponseData;
import com.thanhhanh.beta.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public ResponseData<Book> bookTicket(Book book){
        if(book == null){
            return new ResponseData(HttpStatus.FOUND, "book ticket fail", null);
        }else{
            bookRepository.save(book);
            return new ResponseData(HttpStatus.OK, "success", book);
        }
    }

    public ResponseData<Integer> updateStatus(Integer user_id, Integer schedule_id){
            return new ResponseData(HttpStatus.OK, "book running", bookRepository.updateStatus(user_id, schedule_id));
    }

}
