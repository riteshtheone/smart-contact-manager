package com.realtime.smartcontactmanager.bean;

import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Pattern;
// import jakarta.validation.constraints.Size;

public class UserBean {

    // @Min(value = 3, message = "name is too short",) // not working for string
    // @Size(min = 3, message = "name is too short")
    @NotBlank(message = "please enter your name")
    private String name;

    // @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
    @NotBlank(message = "please enter your email")
    private String email;

    // @Size(min = 4, message = "your password is too short")
    @NotBlank(message = "please enter your password")
    private String password;

    private String description;
    private boolean agreement;

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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isAgreement() {
        return agreement;
    }
    public void setAgreement(boolean agreement) {
        this.agreement = agreement;
    }
    @Override
    public String toString() {
        return "UserBean [name=" + name + ", email=" + email + ", password=" + password + ", description=" + description
                + ", agreement=" + agreement + "]";
    }

}
