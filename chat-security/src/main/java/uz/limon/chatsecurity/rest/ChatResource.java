package uz.limon.chatsecurity.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.limon.chatsecurity.dto.ChatDTO;
import uz.limon.chatsecurity.dto.ResponseDTO;
import uz.limon.chatsecurity.dto.UserDTO;
import uz.limon.chatsecurity.service.ChatService;

@RestController
@RequestMapping("chats")
@RequiredArgsConstructor
public class ChatResource {

    private final ChatService chatService;

    @PostMapping("/add")
    public ResponseDTO<Integer> addChat(@RequestBody ChatDTO chatDTO){
        return chatService.addChat(chatDTO);
    }

    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN', 'ROLE_MODERATOR', 'CHAT')")
    @PostMapping("/add-member")
    public ResponseDTO<String> addMember(@RequestParam Integer chatId, @RequestParam Integer userId){
        return chatService.addMember(chatId, userId);
    }
}
