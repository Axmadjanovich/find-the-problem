package uz.limon.chatsecurity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ApiModel(description = "Model for all API responses")
public class ResponseDTO<T> {

    @ApiModelProperty(notes = "Describes that request is finished successfully")
    private boolean success;

    @ApiModelProperty(notes = "Code of the response")
    private Integer code;

    @ApiModelProperty(notes = "Message of the response")
    private String message;

    @ApiModelProperty(notes = "Data of the response")
    private T data;

    @ApiModelProperty(notes = "If request fails, this field contains causes of fail")
    private List<ValidatorDTO> errors;

    public ResponseDTO(boolean success, Integer code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
