package uz.limon.chatsecurity.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.limon.chatsecurity.dto.ResponseDTO;
import uz.limon.chatsecurity.dto.UserDTO;
import uz.limon.chatsecurity.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserResources {

    private final UserService userService;

    @GetMapping("/check")
    public ResponseDTO<String> get(){
        return new ResponseDTO<>(true, 0, "OK", "OK");
    }

    @PostMapping("/add")
    public ResponseDTO<?> register(@RequestBody @Valid UserDTO userDTO){
        return userService.addUser(userDTO);
    }

    @GetMapping("/token")
    public ResponseDTO<String> jwt(@RequestBody UserDTO userDTO, HttpServletRequest request){
        return userService.generateJWT(userDTO, request);
    }

}
