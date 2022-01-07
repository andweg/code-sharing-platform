package platform;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,
                reason = "There is no code snippet with the specified UUID in the database!")
public class CodeNotFoundException extends RuntimeException {

}
