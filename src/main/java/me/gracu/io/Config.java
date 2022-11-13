package me.gracu.io;

public class Config {
    private String token;
    private String suggestions_channel_id;

    Config() {}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSuggestions_channel_id() {
        return suggestions_channel_id;
    }

    public void setSuggestions_channel_id(String suggestions_channel_id) {
        this.suggestions_channel_id = suggestions_channel_id;
    }
}
