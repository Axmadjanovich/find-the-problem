package uz.limon.chatsecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.limon.chatsecurity.dto.ChatDTO;
import uz.limon.chatsecurity.dto.UserDTO;
import uz.limon.chatsecurity.dto.ValidatorDTO;
import uz.limon.chatsecurity.helper.AppMessages;
import uz.limon.chatsecurity.helper.StringHelper;
import uz.limon.chatsecurity.repository.ChatRepository;
import uz.limon.chatsecurity.repository.ChatUsersRepository;
import uz.limon.chatsecurity.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ValidatorService {

    private final UserRepository userRepository;
    private final ChatRepository chatRepository;
    private final ChatUsersRepository chatUsersRepository;

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

    public List<ValidatorDTO> validateChat(ChatDTO chatDTO) {
        List<ValidatorDTO> errors = new ArrayList<>();

        if (chatRepository.existsByName(chatDTO.getName()))
            errors.add(
                    ValidatorDTO.builder()
                    .error(AppMessages.NOT_UNIQUE)
                    .fieldName("name")
                    .build());

        errors.addAll(chatDTO.getUserIds().stream()
                .filter(id -> !userRepository.existsById(id))
                .map(id -> ValidatorDTO.builder()
                        .fieldName("ID")
                        .error(String.format("User with %d is not exists", id))
                        .build())
                .collect(Collectors.toList()));

        return errors;
    }

    public List<ValidatorDTO> checkUserAndChat(Integer chatId, Integer userId) {
        List<ValidatorDTO> errors = new ArrayList<>();

        if (!userRepository.existsById(userId))
            errors.add(ValidatorDTO.builder()
                    .fieldName("userId")
                    .error(AppMessages.NOT_FOUND)
                    .build());

        if (!chatRepository.existsById(chatId))
            errors.add(ValidatorDTO.builder()
                    .fieldName("chatId")
                    .error(AppMessages.NOT_FOUND)
                    .build());

        if (chatUsersRepository.existsByChatIdAndUserId(chatId, userId))
            errors.add(ValidatorDTO.builder()
                    .fieldName("userId")
                    .error("This user is already exists in this chat")
                    .build());

        return errors;
    }
}
