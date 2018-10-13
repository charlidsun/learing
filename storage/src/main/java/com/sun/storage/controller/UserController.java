package com.sun.storage.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sun.storage.domain.User;
import com.sun.storage.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    CacheManager cacheManager;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/adduser")
    public int addSser(@RequestBody User user) {
    	System.err.println(user.toString());
        return userService.addUser(user);
    }

    @RequestMapping( value = "/getusersbyname", method = RequestMethod.POST)
    public List<User> geUsersByName( @RequestBody User user ) {
        System.out.println( "-------------------------------------------" );
        System.out.println("call /getusersbyname");
        System.out.println(cacheManager.toString());
        List<User> users = userService.getUsersByName(user.getName());
        return users;
    }
}
