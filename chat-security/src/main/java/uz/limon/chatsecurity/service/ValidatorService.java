package uz.limon.chatsecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.limon.chatsecurity.dto.UserDTO;
import uz.limon.chatsecurity.dto.ValidatorDTO;
import uz.limon.chatsecurity.helper.AppMessages;
import uz.limon.chatsecurity.helper.StringHelper;
import uz.limon.chatsecurity.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ValidatorService {

    private final UserRepository userRepository;

    public List<ValidatorDTO> validateUser(UserDTO user){
        //List for errors
        List<ValidatorDTO> errors = new ArrayList<>();

        //check for username is unique in database
        if (userRepository.existsByUsername(user.getUsername()))
            errors.add(ValidatorDTO.builder()
                    .fieldName("username")
                    .error(AppMessages.NOT_UNIQUE)
                    .build());

        //check for password is secure
        String password = user.getPassword();

        if (!StringHelper.isValidPassword(password))
            errors.add(ValidatorDTO
                    .builder()
                    .fieldName("password")
                    .error("Must contains at least 1 lower, 1 upper and 1 numeric character")
                    .build());


        return errors;
    }
}
