package com.thanhhanh.beta.controller;

import com.thanhhanh.beta.request.BookRequest;
import com.thanhhanh.beta.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Api(description = "Api booking")
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @ApiOperation(value = "Book vé xem phim")
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<?> bookTick(Authentication authentication,  @RequestBody BookRequest bookRequest){
        return ResponseEntity.ok(bookService.bookTicket(authentication, bookRequest));
    }
    @ApiOperation(value = "Thay đổi trang thái ghế theo vé")
    @PostMapping(value = "/confirm")
    public ResponseEntity<?> confirmTick(Authentication authentication, @RequestBody HashMap<String, Integer> request){
        return ResponseEntity.ok(bookService.updateStatus(authentication, request.get("bookId")));
    }
}
