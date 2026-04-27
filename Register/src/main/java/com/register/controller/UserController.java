package com.register.controller;

import com.register.model.User;
import com.register.model.UserInvoice;
import com.register.service.UserInvoiceService;
import com.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/userApi/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserInvoiceService userInvoiceService;

    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUser(@PathVariable long userId) {
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUser(
            @PathVariable long userId,
            @RequestBody User user) {

        User updatedUser = userService.updateUser(userId, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }


    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable long userId) {
        userService.deleteUserById(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.NOT_FOUND);
    }

//    @PostMapping("/users/invoice")
//    public ResponseEntity<String> saveInvoiceReference(
//            @RequestParam Long invoiceId,
//            @RequestParam Long userId) {
//
//        return ResponseEntity.ok("Saved");
//    }

    @PostMapping("/invoice/save")
    public void saveInvoiceReference(@RequestBody UserInvoice userInvoice){
        userInvoiceService.saveInvoice(userInvoice);
    }

}
