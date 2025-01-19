package Dev_2025.Dev_2025_Project_Mongo.DTO;

import Dev_2025.Dev_2025_Project_Mongo.Domain.User;

import java.io.Serial;
import java.io.Serializable;

public class UserDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -2135885421924411348L;

    private String id;
    private String name;
    private String email;

    public UserDTO() {
    }

    public UserDTO(User o){
        id = o.getId();
        name = o.getName();
        email = o.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
