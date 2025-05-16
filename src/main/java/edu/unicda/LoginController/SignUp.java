package edu.unicda.LoginController;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("signup")
@ViewScoped
public class SignUp implements Serializable {
    private String name;
    private String surname;
    private int age;
    private String email;
    private String password;
    private String confirmPassword;

    public String save() {
        User user = new User(name, surname, age, email, password);
        UserData.addUser(user); // Use UserData to store users!
        // Reset fields
        name = "";
        surname = "";
        age = 0;
        email = "";
        password = "";
        confirmPassword = "";
        return "Login?faces-redirect=true";
    }

    // Getters and setters for all fields
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
}