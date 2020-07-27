package com.example.crud_json;

public class ProfileModel {
    private String id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private Json json;



    public ProfileModel(String id, String name, String username, String email, String phone) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Json getJson() {
        return json;
    }
}
