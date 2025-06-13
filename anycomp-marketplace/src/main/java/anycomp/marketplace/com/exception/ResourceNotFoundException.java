package anycomp.marketplace.com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    /**
     * 404 not found
     * @param message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
