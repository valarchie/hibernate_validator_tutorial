package validate;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author archie
 * @Date 2019-05-27-17:36
 */
public class PostParamBean {

    @NotNull
    @Valid
    private SubPostParamBean sub;

    @NotNull
    private Long post_id;

    private Long post_field_a;
    @NotBlank
    private String post_field_b;

    @NotEmpty
    private List<String> post_field_c;


    public SubPostParamBean getSub() {
        return sub;
    }

    public void setSub(SubPostParamBean sub) {
        this.sub = sub;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public Long getPost_field_a() {
        return post_field_a;
    }

    public void setPost_field_a(Long post_field_a) {
        this.post_field_a = post_field_a;
    }

    public String getPost_field_b() {
        return post_field_b;
    }

    public void setPost_field_b(String post_field_b) {
        this.post_field_b = post_field_b;
    }

    public List<String> getPost_field_c() {
        return post_field_c;
    }

    public void setPost_field_c(List<String> post_field_c) {
        this.post_field_c = post_field_c;
    }
}
