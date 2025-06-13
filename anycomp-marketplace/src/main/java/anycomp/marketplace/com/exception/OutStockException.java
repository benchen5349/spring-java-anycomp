package anycomp.marketplace.com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class OutStockException extends RuntimeException {
    /**
     * 409 conflict
     * @param message
     */
    public OutStockException(String message) {
        super(message);
    }
}
