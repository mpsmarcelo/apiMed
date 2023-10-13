package med.voll.apiMed.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomError {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity getError404(){
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity getErro400(MethodArgumentNotValidException exception){
        var error =  exception.getFieldErrors();
        return ResponseEntity.badRequest().body(error.stream().map(FieldValidation::new).toList());
    }

    private record FieldValidation(String field, String msg){
        public FieldValidation(FieldError error){
            this(error.getField(), error.getDefaultMessage());

        }
    }
}
