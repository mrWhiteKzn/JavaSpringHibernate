package exampro.entity;

import exampro.entity.enums.UserRole;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;

    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    public UserEntity() {
    }

    public UserEntity(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
