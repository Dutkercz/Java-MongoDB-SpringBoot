package Dev_2025.Dev_2025_Project_Mongo.Services.Exception;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 5772376792384419395L;

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
