package uz.limon.chatsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    protected Integer id;
    @NotBlank(message = "Ism bo'sh bo'lmasligi kerak")
    @Max(value = 3, message = "Eng kamida 3 ta belgi bo'lishligi kerak")
    protected String firstName;
    @NotBlank(message = "Familiya bo'sh bo'lmasligi kerak")
    @Max(value = 3, message = "Eng kamida 3 ta belgi bo'lishligi kerak")
    protected String lastName;
    @NotBlank(message = "Tel. raqam bo'sh bo'lmasligi kerak")
    @Pattern(regexp = "/^([+]?\\d{3}[-\\s]?|)\\d{2}[-\\s]?\\d{3}[-\\s]?\\d{2}[-\\s]?\\d{2}$/", message = "Tel. raqam mos kelmadi")
    protected String phoneNumber;
    @Digits(integer = 10, fraction = 2)
    protected BigDecimal account;
    @NotBlank(message = "Username bo'sh bo'lmasligi kerak")
    protected String username;
    @NotBlank(message = "Password bo'sh bo'lmasligi kerak")
    protected String password;

    public UserDTO(Integer id, String firstName, String lastName, String phoneNumber, BigDecimal account, String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.account = account;
        this.username = username;
    }
}

