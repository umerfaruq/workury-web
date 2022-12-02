package com.workury.workuryweb.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "User")
public class UserEntity {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String role;

    List<String> following = new ArrayList<>();

    List<String> follower = new ArrayList<>();
}
