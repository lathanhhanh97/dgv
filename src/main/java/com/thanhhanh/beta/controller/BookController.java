package com.thanhhanh.beta.controller;

import com.thanhhanh.beta.entity.Book;
import com.thanhhanh.beta.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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
    public ResponseEntity<?> bookTick(@RequestBody Book book){
        return ResponseEntity.ok(bookService.bookTicket(book));
    }
    @ApiOperation(value = "Thay đổi trang thái ghế theo vé")
    @PostMapping(value = "/confirm")
    public ResponseEntity<?> confirmTick(@RequestBody HashMap<String, Integer> request){
        return ResponseEntity.ok(bookService.updateStatus(request.get("userId"), request.get("scheduleId")));
    }
}
