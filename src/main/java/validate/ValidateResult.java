package validate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author archie
 * @Date 2019-05-25-15:46
 */
public class ValidateResult<T> {


    private T paramData;

    private boolean error;
    private Map errorMsgMap;

    public T getParamData() {
        return paramData;
    }

    public void setParamData(T paramData) {
        this.paramData = paramData;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public Map getErrorMsgMap() {
        return errorMsgMap;
    }

    public void setErrorMsgMap(Map errorMsgMap) {
        this.errorMsgMap = errorMsgMap;
    }

    public String getErrorMsg() {

        StringBuilder errorMsg = new StringBuilder();

        if (errorMsgMap != null) {

            for (Object key : errorMsgMap.keySet()) {

                errorMsg.append(key + "" + errorMsgMap.get(key) + "，");

            }

            if (errorMsg.length() > 0) {
                errorMsg.deleteCharAt(errorMsg.length() - 1);
            }

        }

        if (errorMsg.length() == 0) {

            errorMsg = new StringBuilder(" Unknown error !");
        }

        return errorMsg.toString();
    }



}
