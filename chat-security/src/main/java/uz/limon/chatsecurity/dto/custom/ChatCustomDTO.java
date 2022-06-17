package uz.limon.chatsecurity.dto.custom;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.limon.chatsecurity.dto.ChatDTO;

@EqualsAndHashCode(callSuper = true)
@Data
public class ChatCustomDTO extends ChatDTO {
    @ApiModelProperty(notes = "Creator of the chat")
    private String author;
}
