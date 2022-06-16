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

    @ManyToMany
//    @JoinTable(name = "users_chats",
//            inverseJoinColumns = {
//                    @JoinColumn(referencedColumnName = "users_id")
//            },
//            joinColumns = {
//                    @JoinColumn
//                            (referencedColumnName = "chats_id")})
    private List<User> users;
}
