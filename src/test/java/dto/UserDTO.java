package dto;

public class UserDTO {

    String email;

    String password;

    public UserDTO() {

    }

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
