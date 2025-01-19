package Dev_2025.Dev_2025_Project_Mongo.Resources;

import java.io.Serial;


public class StandardErrorException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -1210078736898139593L;

    private Long timestamp;
    private Integer status;
    private String message;
    private String error;
    private String path;

    public StandardErrorException(Long timestamp, Integer status, String message, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.message =message;
        this.error = error;
        this.path = path;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}