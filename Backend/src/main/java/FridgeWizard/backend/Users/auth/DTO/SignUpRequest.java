package FridgeWizard.backend.Users.auth.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SignUpRequest {
    @NotBlank(message = "Must have email")
    private String email;

    @NotBlank(message = "Must have username")
    @Size(max = 20, message = "Username cannot be longer than 20 characters.")
    private String username;

    @NotBlank(message = "Must have password")
    @Size(max = 20, message = "Password cannot be longer than 20 characters.")
    private String password;

    public SignUpRequest(String username, String email, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
