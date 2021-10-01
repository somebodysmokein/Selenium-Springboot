package com.venky.interview;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "selenium")
public class ConfigMgr {

    private Map<String, String> application;
    private Map<String, Hashtable<String, String>> config;
    private Map<String, Credential> users;

    public Map<String, String> getApplication() {
        return application;
    }

    public void setApplication(Map<String, String> application) {
        this.application = application;
    }

    public Map<String, Hashtable<String, String>> getConfig() {
        return config;
    }

    public void setConfig(Map<String, Hashtable<String, String>> config) {
        this.config = config;
    }

    public Map<String, Credential> getUsers() {
        return users;
    }

    public void setUsers(Map<String, Credential> users) {
        this.users = users;
    }

    public static class Credential {

        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}