package md.utm.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Utilizator not found")
public class UtilizatorNotFoundException extends Exception{

    public UtilizatorNotFoundException(Long id){
        super("UtilizatorNotFoundException with id = " + id);
    }
}
