package API.pojo;

import io.cucumber.java.it.Ma;

import java.util.Map;

public class RegresPojo {

    private String data;
    private Map<String,Integer> id;
    private Map<String,String> email;
    private Map<String, Map<String,String>> first_name;
    private Map<String, Map<String,String>> last_name;
    private Map<String, Map<String,String>> avatar;
    private  String ad;
    private Map<String, Map<String,String>> company;
    private Map<String, Map<String,String>> url;
    private Map<String, Map<String,String>> text;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Map<String, Integer> getId() {
        return id;
    }

    public void setId(Map<String, Integer> id) {
        this.id = id;
    }

    public Map<String, String> getEmail() {
        return email;
    }

    public void setEmail(Map<String, String> email) {
        this.email = email;
    }

    public Map<String, Map<String, String>> getFirst_name() {
        return first_name;
    }

    public void setFirst_name(Map<String, Map<String, String>> first_name) {
        this.first_name = first_name;
    }

    public Map<String, Map<String, String>> getLast_name() {
        return last_name;
    }

    public void setLast_name(Map<String, Map<String, String>> last_name) {
        this.last_name = last_name;
    }

    public Map<String, Map<String, String>> getAvatar() {
        return avatar;
    }

    public void setAvatar(Map<String, Map<String, String>> avatar) {
        this.avatar = avatar;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public Map<String, Map<String, String>> getCompany() {
        return company;
    }

    public void setCompany(Map<String, Map<String, String>> company) {
        this.company = company;
    }

    public Map<String, Map<String, String>> getUrl() {
        return url;
    }

    public void setUrl(Map<String, Map<String, String>> url) {
        this.url = url;
    }

    public Map<String, Map<String, String>> getText() {
        return text;
    }

    public void setText(Map<String, Map<String, String>> text) {
        this.text = text;
    }
}
