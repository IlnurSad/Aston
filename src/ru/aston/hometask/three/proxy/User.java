package ru.aston.hometask.three.proxy;

import java.util.List;

public class User {
    private final String name;
    private final List<String> permissions;

    public User(String name, List<String> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public boolean hasPermission(String permission) {
        return permissions.contains(permission);
    }
}