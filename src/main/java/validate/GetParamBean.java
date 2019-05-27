package validate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @Author archie
 * @Date 2019-05-27-16:46
 */
public class GetParamBean extends PageParamBean {

    @NotNull
    private Long condition_a;

    private Long condition_b;

    @NotBlank
    private String condition_c;

    @NotEmpty
    private List<Long> condition_d;


    public Long getCondition_a() {
        return condition_a;
    }

    public void setCondition_a(Long condition_a) {
        this.condition_a = condition_a;
    }

    public Long getCondition_b() {
        return condition_b;
    }

    public void setCondition_b(Long condition_b) {
        this.condition_b = condition_b;
    }

    public String getCondition_c() {
        return condition_c;
    }

    public void setCondition_c(String condition_c) {
        this.condition_c = condition_c;
    }

    public List<Long> getCondition_d() {
        return condition_d;
    }

    public void setCondition_d(List<Long> condition_d) {
        this.condition_d = condition_d;
    }
}
