package uz.limon.chatsecurity.mapper;

import org.mapstruct.Mapper;
import uz.limon.chatsecurity.dto.ChatDTO;
import uz.limon.chatsecurity.model.Chat;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    ChatDTO toDto(Chat chat);
    Chat toEntity(ChatDTO chatDTO);
}
