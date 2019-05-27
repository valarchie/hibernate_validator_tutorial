package validate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Author archie
 * @Date 2019-05-27-16:51
 */
public class PageParamBean {


    @NotNull
    @Max(10000)
    private Integer page_size;


    @NotNull
    @Min(1)
    private Integer page_num;


    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }

    public Integer getPage_num() {
        return page_num;
    }

    public void setPage_num(Integer page_num) {
        this.page_num = page_num;
    }
}
