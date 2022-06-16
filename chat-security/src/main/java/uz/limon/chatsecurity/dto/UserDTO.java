package uz.limon.chatsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.limon.chatsecurity.helper.AppMessages;

import javax.validation.constraints.*;
import java.math.BigDecimal;

import static uz.limon.chatsecurity.helper.AppMessages.EMPTY_FIELD;
import static uz.limon.chatsecurity.helper.AppMessages.MISMATCH;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    protected Integer id;
    @NotBlank(message = EMPTY_FIELD)
    @Min(value = 3, message = "At least must be 3 characters")
    protected String firstName;
    @NotBlank(message = EMPTY_FIELD)
    @Min(value = 3, message = "At least must be 3 characters")
    protected String lastName;
    @NotBlank(message = EMPTY_FIELD)
    @Pattern(regexp = "/^([+]?\\d{3}[-\\s]?|)\\d{2}[-\\s]?\\d{3}[-\\s]?\\d{2}[-\\s]?\\d{2}$/", message = MISMATCH)
    protected String phoneNumber;
    @NotBlank(message = EMPTY_FIELD)
    protected String username;
    @NotBlank(message = EMPTY_FIELD)
    protected String password;

    public UserDTO(Integer id, String firstName, String lastName, String phoneNumber, String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.username = username;
    }
}

