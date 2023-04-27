package shitta.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

    private int id;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;

    private String email;
}
