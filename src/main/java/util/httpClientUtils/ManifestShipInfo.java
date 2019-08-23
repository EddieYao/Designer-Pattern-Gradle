package util.httpClientUtils;



import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yongqiangyao
 * @description 录入接口
 */
public class ManifestShipInfo {
    /*
      * 测试账号密码
     */
    public static String url = "http://outsite.szflow.com:3301/MainfestInterface.asmx?op=ManifestShipInfo";

    public static void main(String[] args) {

        try {
            Map<String, String> beanMap = new HashMap<>();
            beanMap.put("shipName", "66");
            beanMap.put("voyNo", "100E");
            beanMap.put("imo", "UN9307009");
            beanMap.put("wharf", "100E");
            beanMap.put("platform", "West");
            //实例化接口
            HttpClientUtil clientUtil = new HttpClientUtil();
            String ajaxResultStr = clientUtil.executeByPOST(url, beanMap);
            JSONObject jsonObject = (JSONObject)JSONObject.parse(ajaxResultStr);
            System.out.println(ajaxResultStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
