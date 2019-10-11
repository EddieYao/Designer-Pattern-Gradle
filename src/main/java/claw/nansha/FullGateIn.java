package claw.nansha;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import util.httpClientUtils.HttpClientUtil;

public class FullGateIn {
    public static String fullGateInBeginUrl = "http://eportal.goct.com.cn/PublicInquire/FullGateIn/GetFullGateIn/?_dc=1570783494141&action=read&sType=CNTR_NO&sValue=";
    public static String fullGateInEndUrl = "&page=1&start=0&limit=25";

    public static void main(String[] args) {
        HttpClientUtil clientUtil = new HttpClientUtil();
        String conaNo = "MRKU4155642";
        String ajaxResultStr = clientUtil.executeByGET(fullGateInBeginUrl + conaNo + fullGateInEndUrl);
        JSONObject jsonObject = (JSONObject) JSONObject.parse(ajaxResultStr);
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        if (jsonArray != null && jsonArray.size() > 0) {
            JSONObject josnObjectResult = (JSONObject) jsonArray.get(0);
            String vslNm = (String) josnObjectResult.get("VSL_NM");
            String outVoy = (String) josnObjectResult.get("OUT_VOY");
            String bookingNo = (String) josnObjectResult.get("BOOKING_NO");
            System.out.println("船名：" + vslNm + "\n航次：" + outVoy + "\n订舱单号：" + bookingNo);
        }
        System.out.println(ajaxResultStr);
    }
}
