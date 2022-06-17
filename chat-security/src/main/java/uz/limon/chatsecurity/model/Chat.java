package uz.limon.chatsecurity.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "chat")
@Data
public class Chat {

    @Id
    @GeneratedValue(generator = "chat_seq")
    @SequenceGenerator(name = "chat_seq", sequenceName = "chat_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "author_id")
    private Integer authorId;

    @ManyToMany
    @JoinTable(name = "chat_users",
            inverseJoinColumns = {
                    @JoinColumn(name = "users_id")
            },
            joinColumns = {
                    @JoinColumn
                            (name = "chats_id")})
    private List<User> users;
}
