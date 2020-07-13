package API.pojo.CatFactClass;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class All {

    private String _id;
    private String text;
    private String type;
    private User user;
    private int upvotes;
    private String userUpvoted;


}
