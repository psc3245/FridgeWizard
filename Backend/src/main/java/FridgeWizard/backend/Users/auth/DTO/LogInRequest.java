package FridgeWizard.backend.Users.auth.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LogInRequest {
    @NotBlank(message = "Must have email or username")
    private String emailOrUsername;

    @NotBlank(message = "Must have password")
    @Size(max = 20, message = "Password cannot be longer than 20 characters.")
    private String password;

    public LogInRequest(String emailOrUsername, String password) {
        this.emailOrUsername = emailOrUsername;
        this.password = password;
    }


    public String getEmailOrUsername() {
        return emailOrUsername;
    }

    public void setEmailOrUsername(String emailOrUsername) {
        this.emailOrUsername = emailOrUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

