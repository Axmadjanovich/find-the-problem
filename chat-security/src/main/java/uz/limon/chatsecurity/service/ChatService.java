package uz.limon.chatsecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.limon.chatsecurity.dto.ChatDTO;
import uz.limon.chatsecurity.dto.ResponseDTO;
import uz.limon.chatsecurity.dto.UserDTO;
import uz.limon.chatsecurity.dto.ValidatorDTO;
import uz.limon.chatsecurity.helper.AppCode;
import uz.limon.chatsecurity.helper.AppMessages;
import uz.limon.chatsecurity.mapper.ChatMapper;
import uz.limon.chatsecurity.model.Chat;
import uz.limon.chatsecurity.model.ChatUsers;
import uz.limon.chatsecurity.model.User;
import uz.limon.chatsecurity.repository.ChatRepository;
import uz.limon.chatsecurity.repository.ChatUsersRepository;
import uz.limon.chatsecurity.repository.UserRepository;

import java.util.Date;
import java.util.List;

import static uz.limon.chatsecurity.helper.AppCode.VALIDATOR_ERROR;
import static uz.limon.chatsecurity.helper.AppMessages.VALIDATOR_MESSAGE;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;
    private final ValidatorService validatorService;
    private final UserRepository userRepository;
    private final ChatMapper chatMapper;
    private final ChatUsersRepository chatUsersRepository;

    public ResponseDTO<Integer> addChat(ChatDTO chatDTO){
        List<ValidatorDTO> errors = validatorService.validateChat(chatDTO);
        if (!errors.isEmpty())
            return new ResponseDTO<>(false, VALIDATOR_ERROR, VALIDATOR_MESSAGE, null, errors);

        List<User> users = userRepository.findAllById(chatDTO.getUserIds());

        Chat chat = chatMapper.toEntity(chatDTO);
        chat.setUsers(users);
        chat.setCreatedAt(new Date());

        chatRepository.save(chat);

        return new ResponseDTO<>(true, AppCode.OK, AppMessages.OK, chat.getId());
    }

    public ResponseDTO<String> addMember(Integer chatId, Integer userId) {
        List<ValidatorDTO> errors = validatorService.checkUserAndChat(chatId, userId);
        if (!errors.isEmpty())
            return new ResponseDTO<>(false, VALIDATOR_ERROR, VALIDATOR_MESSAGE, null, errors);

        ChatUsers chatUsers = new ChatUsers();
        chatUsers.setChatId(chatId);
        chatUsers.setUserId(userId);

        chatUsersRepository.save(chatUsers);

        return new ResponseDTO<>(true, AppCode.OK, AppMessages.OK, AppMessages.SAVED);
    }
}
