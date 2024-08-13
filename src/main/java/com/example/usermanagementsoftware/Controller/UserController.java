package com.example.usermanagementsoftware.Controller;

import com.example.usermanagementsoftware.Model.User;
import com.example.usermanagementsoftware.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUsers()
    {
        return ResponseEntity.status(200).body(userService.getUsers());
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@Valid@RequestBody User user, Errors errors)
    {
        if(errors.hasErrors())
        {
            String m = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(m);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@Valid@RequestBody User user,Errors errors)
    {
        if(errors.hasErrors())
        {
            String m = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(m);
        }
        userService.updateUser(id, user);
        return ResponseEntity.status(200).body("User updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id)
    {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("User deleted");
    }
    @GetMapping("/check-username-and-password/{username}/{password}")
    public ResponseEntity checkUsernameAndPassword(@PathVariable String username,@PathVariable String password)
    {
        return ResponseEntity.status(200).body(userService.checkUsernameAndPassword(username, password));
    }
    @GetMapping("/get-user-by-email/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email)
    {
        return ResponseEntity.status(200).body(userService.getUserByEmail(email));
    }
    @GetMapping("/get-users-by-role/{role}")
    public ResponseEntity getUsersByRole(@PathVariable String role)
    {
        return ResponseEntity.status(200).body(userService.getUsersByRole(role));
    }
    @GetMapping("/find-user-by-age-or-above/{age}")
    public ResponseEntity findUserByAgeOrAbove(@PathVariable int age)
    {
        return ResponseEntity.status(200).body(userService.findUserByAgeOrAbove(age));
    }
}
