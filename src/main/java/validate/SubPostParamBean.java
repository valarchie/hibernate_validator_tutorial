package validate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @Author archie
 * @Date 2019-05-27-17:36
 */
public class SubPostParamBean {

    private Long sub_id;

    @NotBlank
    private String sub_field_a;


    public Long getSub_id() {
        return sub_id;
    }

    public void setSub_id(Long sub_id) {
        this.sub_id = sub_id;
    }

    public String getSub_field_a() {
        return sub_field_a;
    }

    public void setSub_field_a(String sub_field_a) {
        this.sub_field_a = sub_field_a;
    }
}
