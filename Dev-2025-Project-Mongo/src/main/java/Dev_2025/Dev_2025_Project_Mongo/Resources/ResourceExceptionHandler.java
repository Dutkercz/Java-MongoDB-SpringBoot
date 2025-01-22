package Dev_2025.Dev_2025_Project_Mongo.Resources;

import Dev_2025.Dev_2025_Project_Mongo.Resources.exceptions.StandardErrorException;
import Dev_2025.Dev_2025_Project_Mongo.Services.Exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardErrorException> objectNotFound(ObjectNotFoundException o, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardErrorException err = new StandardErrorException(System.currentTimeMillis(), status.value(), "Não encontrado",
                o.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);

    }
}
