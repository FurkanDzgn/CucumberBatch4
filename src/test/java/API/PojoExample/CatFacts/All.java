package API.PojoExample.CatFacts;

import org.apache.commons.lang3.ObjectUtils;

public class All {

    private String _id;
    private String text;
    private String type;
    private User user;
    private Integer upvotes;
    private ObjectUtils.Null userUpvoted;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    public ObjectUtils.Null getUserUpvoted() {
        return userUpvoted;
    }

    public void setUserUpvoted(ObjectUtils.Null userUpvoted) {
        this.userUpvoted = userUpvoted;
    }
}
