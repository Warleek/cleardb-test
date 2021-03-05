package com.bertrand.test.cleardb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public int createUsers(List<String> names) {
        List<User> users =names.stream().map(User::new).collect(Collectors.toList());
        return repo.saveAll(users).size();
    }

    public List<User> getAll() {
        return repo.findAll();
    }
}
