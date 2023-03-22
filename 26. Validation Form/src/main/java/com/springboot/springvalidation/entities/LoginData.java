package com.springboot.springvalidation.entities;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginData {

    @NotBlank(message = "Username shouldn't be blank")
    @Size(min = 3, max = 8, message = "Username must be between 3 - 8 characters")
    public String userName;

    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid Email !!")
    public String email;
    
    @AssertTrue(message = "Must agree terms & conditions !!")
    public boolean agreed;

    @Override
    public String toString() {
        return "LoginData [userName=" + userName + ", email=" + email + "]";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public boolean isAgreed() {
		return agreed;
	}

	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}

}
