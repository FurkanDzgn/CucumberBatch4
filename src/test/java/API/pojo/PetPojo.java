package API.pojo;

import java.util.List;
import java.util.Map;

public class PetPojo {

    private int id;
    private Map<String,Object> category;
    private List<String> photoUrls;
    private List<Map<String,Object>> tags;
    private String status;

//    public PetPojo(String status, int id){
//        this.id=id;
//        this.status=status;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Object> getCategory() {
        return category;
    }

    public void setCategory(Map<String, Object> category) {
        this.category = category;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Map<String, Object>> getTags() {
        return tags;
    }

    public void setTags(List<Map<String, Object>> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
