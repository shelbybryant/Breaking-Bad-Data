package com.revature.jwtservices;

import com.revature.models.User;
import com.revature.jwtrepositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    public UserService() {
    }

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<Author> findAll (){
        return authorRepository.findAll();
    }

    public Optional<Author> findById(Long id){
        return authorRepository.findById(id);
    }

    public Author findByNameAndSurname(String name, String surname){
        return authorRepository.findByNameAndSurnameAllIgnoreCase(name, surname);
    }

    public void save(Author author){
        authorRepository.save(author);
    }

    public void update(Author author){
        authorRepository.save(author);
    }

    public void delete(Long id){
        authorRepository.deleteById(id);
    }
