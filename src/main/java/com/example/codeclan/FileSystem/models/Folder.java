package com.example.codeclan.FileSystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folders")
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;






    @JsonIgnoreProperties(value = "folders")
    @ManyToMany
    @JoinTable(
            name = "folders_users",
            joinColumns = { @JoinColumn(name = "folder_id",  updatable = false)},
            inverseJoinColumns = { @JoinColumn(name = "user_id", updatable = false)}

    )
    private List<User> users;

    @OneToMany(mappedBy = "folder")
    private List<File> files;


    public Folder(String title) {
        this.title = title;
        this.files = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public Folder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
//
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public void addUser(User user){
        this.users.add(user);
    }
}

