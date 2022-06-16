package uz.limon.chatsecurity.model;

import lombok.Data;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;

@Entity
@Table(name = "chat_users")
@Data
public class ChatUsers {

    @Id
    @Column(name = "chats_id")
    private Integer chatId;

    @Column(name = "users_id")
    private Integer userId;
}
