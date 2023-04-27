package shitta.dto.responses;

public class RegisterUserResponse {

    private String firstName;
    private int id;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RegisterUserResponse{" +
                "firstName='" + firstName + '\'' +
                ", id=" + id +
                '}';
    }
}
