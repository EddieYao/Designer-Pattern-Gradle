package claw.nansha;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import util.httpClientUtils.HttpClientUtil;

public class Inventory {
    public static String inventoryBeginUrl = "http://eportal.goct.com.cn/PublicInquire/Inventory/GetInventory/?_dc=1570782362076&action=read&cName=CNTR_NO&cValue=";
    public static String inventoryEndUrl = "&cFE=&page=1&start=0&limit=25";

    public static void main(String[] args) {
        HttpClientUtil clientUtil = new HttpClientUtil();
        String conaNo = "MRKU4155642";
        String ajaxResultStr = clientUtil.executeByGET(inventoryBeginUrl + conaNo + inventoryEndUrl);
        JSONObject jsonObject = (JSONObject) JSONObject.parse(ajaxResultStr);
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        if (jsonArray != null && jsonArray.size() > 0) {
            JSONObject josnObjectResult = (JSONObject) jsonArray.get(0);
            String fE = (String) josnObjectResult.get("FE");
            String sealNo3 = (String) josnObjectResult.get("SEAL_NO3");
            String operator = (String) josnObjectResult.get("OPERATOR");
            String pol = (String) josnObjectResult.get("POL");
            String pod = (String) josnObjectResult.get("POD");
            System.out.println("箱状态：" + fE + "\n封条号：" + operator + "\n箱属：" + sealNo3 + "\n装货港：" + pol + "\n卸货港：" + pod);
        }
        System.out.println(ajaxResultStr);
    }
}
