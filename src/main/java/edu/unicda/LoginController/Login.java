package edu.unicda.LoginController;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;

@Named("login")
@ViewScoped
public class Login implements Serializable {
    private String email;
    private String password;

    public String login() {
        User user = UserData.getUserByEmailAndPassword(email, password);
        if (user != null) {
            // Possibly store user in session here
            return "Product?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid email or password.", null));
            return null;
        }
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}