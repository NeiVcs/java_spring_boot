package neivcs.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity errorHandler400(MethodArgumentNotValidException ex){
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(ValidationsErrosData::new).toList());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity errorHandler404(){
        return ResponseEntity.notFound().build();
    }

    private record ValidationsErrosData(String field, String message){
        public ValidationsErrosData(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
