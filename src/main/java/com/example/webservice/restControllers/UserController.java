package com.example.webservice.restControllers;

import com.example.webservice.dto.UserDto;
import com.example.webservice.models.User;
import com.example.webservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/get_user/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.get(id));
    }


    @PostMapping("/add_user")
    public ResponseEntity<User> addNewUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.save(User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .build()));
    }

    @PutMapping("/edit/{user-id}")
    public ResponseEntity<User> addNewUser(@RequestBody UserDto userDto,
                            @PathVariable("user-id") Long id){
        return ResponseEntity.ok(userService.save(User.builder()
                .id(id)
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .build()));
    }

    @DeleteMapping("/delete/{user-id}")
    public ResponseEntity<?> deleteUser(@PathVariable("user-id") Long id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
