package uz.limon.chatsecurity.dto;

import lombok.Data;
import uz.limon.chatsecurity.helper.AppMessages;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

import static uz.limon.chatsecurity.helper.AppMessages.EMPTY_FIELD;

@Data
public class ChatDTO {

    private Integer id;
    @NotBlank(message = EMPTY_FIELD)
    private String name;
    @Size(min = 1, message = "Chat members must be at least one")
    private List<Integer> userIds;
    private Date createdAt;
}
