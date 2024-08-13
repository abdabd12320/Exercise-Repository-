package com.example.usermanagementsoftware.Service;

import com.example.usermanagementsoftware.Api.ApiException;
import com.example.usermanagementsoftware.Model.User;
import com.example.usermanagementsoftware.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    public void addUser(User user)
    {
        userRepository.save(user);
    }

    public void updateUser(Integer id,User user)
    {
        User u = userRepository.findUserById(id);
        if(u == null)
            throw new ApiException("not found");

        u.setName(user.getName());
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setAge(user.getAge());
        u.setRole(user.getRole());
        userRepository.save(u);
    }
    public void deleteUser(Integer id)
    {
        if(userRepository.findUserById(id) == null) {
            throw new ApiException("not found");
        }

        userRepository.deleteById(id);
    }
    public User checkUsernameAndPassword(String username,String password)
    {
        if(userRepository.checkUsernameAndPassword(username, password) == null)
        {
            throw new ApiException("There is no match");
        }
        return userRepository.checkUsernameAndPassword(username, password);
    }
    public User getUserByEmail(String email)
    {
        if(userRepository.findUserByEmail(email) == null)
        {
            throw new ApiException("not found");
        }
        return userRepository.findUserByEmail(email);
    }
    public List<User> getUsersByRole(String role)
    {
        if(userRepository.findUserByRole(role).isEmpty())
        {
            throw new ApiException("it is empty");
        }
       return userRepository.findUserByRole(role);
    }
    public List<User> findUserByAgeOrAbove(int age)
    {
        if(userRepository.findUserByAgeOrAbove(age).isEmpty())
        {
            throw new ApiException("not found");
        }
        return userRepository.findUserByAgeOrAbove(age);
    }

}
