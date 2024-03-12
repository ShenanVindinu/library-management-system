package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    private String name;

    private String email;

    @Id
    private String userName;

    private String password;
}
