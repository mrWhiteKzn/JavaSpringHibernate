package exampro.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    Admin,
    Student;

    UserRole() {
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
