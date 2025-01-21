package Dev_2025.Dev_2025_Project_Mongo.DTO;

import Dev_2025.Dev_2025_Project_Mongo.Domain.User;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class AuthorDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -7537354253132562356L;

    private String id;
    private String name;

    public AuthorDTO() {
    }

    public AuthorDTO(User o) {
        id = o.getId();
        name = o.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
