package singlewindow;

import util.httpClientUtils.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 蛇口港信息服务接口工具类
 *
 * @author willchen
 * @since 2019-08-02 13:44:44
 */
public class SingleWindow {
    
    public static String url = "https://publicservice.singlewindow.gz.cn/restQRShipment/qrshipment/getShipment";

    public static void main(String[] args) throws Exception{
        HttpClientUtil clientUtil = new HttpClientUtil();
        Map<String, String> params = new HashMap<>();
        params.put("userCode","4422930877");
        params.put("password","xb888888");
        String ajaxResultStr = clientUtil.executeByPOST(url,params);
        System.out.println(ajaxResultStr);
    }
}
