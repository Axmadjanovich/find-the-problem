package uz.limon.chatsecurity.dto.custom;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.limon.chatsecurity.dto.ChatDTO;
import uz.limon.chatsecurity.dto.UserDTO;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserCustomDTO extends UserDTO {
    private List<ChatCustomDTO> chats;
}
