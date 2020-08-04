package API.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PetPojoRequest {

    private String name;
    private Integer age;
    private String status;
    private Integer id;
    private String photoUrl;

    public PetPojoRequest(String name, String status, Integer id){
        this.name=name;
        this.status=status;
        this.id=id;
    }
}
