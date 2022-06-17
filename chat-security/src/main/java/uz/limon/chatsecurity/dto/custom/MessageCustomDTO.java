package uz.limon.chatsecurity.dto.custom;

import lombok.Data;

@Data
public class MessageCustomDTO {

    private String userName;
    private String chatName;
    private String content;
    private String type;
    private String ext;
    private String createdAt;

}
