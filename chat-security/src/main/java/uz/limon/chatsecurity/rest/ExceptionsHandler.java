package uz.limon.chatsecurity.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import uz.limon.chatsecurity.dto.ValidatorDTO;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidatorDTO>> handle(MethodArgumentNotValidException e, WebRequest request) {
        List<ValidatorDTO> errors = e.getBindingResult().getFieldErrors().stream()
                .map(ee -> ValidatorDTO.builder()
                            .fieldName(ee.getField())
                        .error(ee.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}
