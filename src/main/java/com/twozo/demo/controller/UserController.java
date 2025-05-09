package com.twozo.demo.controller;

import com.twozo.demo.model.Dto.ResponseDto;
import com.twozo.demo.model.Dto.UserDto;
import com.twozo.demo.model.User;
import com.twozo.demo.service.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserServices userService;

    
    public UserController(UserServices userService) {
         this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@RequestBody User user) {
        int result = userService.checkUserRegistration(user);
        if(result == 3){
            return  ResponseEntity.ok(new ResponseDto("User Registered Successfully"));
        }
        else if(result == 1){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ResponseDto("This User name already taken, try another"));
        }
        else if(result == 2){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ResponseDto("This phone number already taken, try another"));
        }
        return ResponseEntity.badRequest()
                .body(new ResponseDto("Password must contain minimum 8 digits."));
    }



    @PutMapping("/updatePassword")
    public ResponseEntity<ResponseDto> updatePassword(@RequestBody UserDto userDto) {
       UserDto user = new UserDto();
         user.setUserId(userDto.getUserId());
         user.setPassword(userDto.getPassword());

        boolean result = userService.updatePassword(user);
        if(result){
            return ResponseEntity.ok(new ResponseDto("password updated successfully"));
        }
        return ResponseEntity.badRequest()
                .body(new ResponseDto("Password must contain minimum 8 digits."));
    }


    @PutMapping("/updateName")
    public ResponseEntity<ResponseDto> updateName(@RequestBody UserDto userDto) {
        UserDto user = new UserDto();
        user.setPhNo(userDto.getPhNo());
        user.setName(userDto.getName());

        boolean result = userService.updateUserName(user);
        if(result){
            return ResponseEntity.ok(new ResponseDto("User Name updated successfully"));
        }
        return ResponseEntity.badRequest()
                .body(new ResponseDto("This user name is already taken try another"));
    }


    @PutMapping("/updatePhone")
    public ResponseEntity<ResponseDto> updatePhone(@RequestBody UserDto userDto) {
        UserDto user = new UserDto();
        user.setPhNo(userDto.getPhNo());
        user.setName(userDto.getName());

        boolean result = userService.updateUserPhNo(user);
        if(result){
            return ResponseEntity.ok(new ResponseDto("User Phone No updated successfully"));
        }
        return  ResponseEntity.badRequest()
                .body(new ResponseDto("This phone Number is already registered try another"));
    }


    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteUser(@RequestBody UserDto userDto) {
        UserDto user = new UserDto();
        user.setPhNo(userDto.getPhNo());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());

        boolean result = userService.deleteUser(user);
        if(result){
            return ResponseEntity.ok(new ResponseDto("User deleted successfully"));
        }
        return ResponseEntity.badRequest()
                .body(new ResponseDto("User Details not found"));
    }


    @GetMapping("/getUserData")
    public ResponseEntity<UserDto> getUserData(@RequestParam String userInfo) {
        UserDto userDto = userService.getUser(userInfo);
        if(userDto != null) {
            return ResponseEntity.ok(new UserDto(userDto.getId(),userDto.getPhNo(),userDto.getName(),userDto.getPassword()));
        }
        return ResponseEntity.badRequest()
                .body(new UserDto());
    }

    @GetMapping("/getUserId")
    public ResponseEntity<ResponseDto> getUserId(@RequestParam String userDetail) {
        int userId = userService.getUserId(userDetail);
        if (userId > 0) {
            return ResponseEntity.ok(new ResponseDto("userId :"+userId));
        }
        return ResponseEntity.badRequest()
                    .body(new ResponseDto("No Users found with this details"));

    }
}

