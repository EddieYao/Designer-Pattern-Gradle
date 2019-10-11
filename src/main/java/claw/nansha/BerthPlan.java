package claw.nansha;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import util.httpClientUtils.HttpClientUtil;
import util.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BerthPlan {
    public static String berthPlanBeginUrl = "http://eportal.goct.com.cn/PublicInquire/BerthPlan/GetBerthPlan/?_dc=1570784544519&action=read&sDate=";
    public static String berthPlanEndUrl = "&page=1&start=0&limit=25";

    public static void main(String[] args) {
        HttpClientUtil clientUtil = new HttpClientUtil();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = sdf.format(new Date());
        String eDate = sdf.format(DateUtil.getOffsiteDate(new Date(), Calendar.DAY_OF_MONTH, 7));

        System.out.println(sDate + "\n" + eDate);

        String ajaxResultStr = clientUtil.executeByGET(berthPlanBeginUrl + sDate + "&eDate=" + eDate + berthPlanEndUrl);
        System.out.println(berthPlanBeginUrl + sDate + "eDate=" + eDate + berthPlanEndUrl);
        JSONObject jsonObject = (JSONObject) JSONObject.parse(ajaxResultStr);
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        if (jsonArray != null && jsonArray.size() > 0) {
            JSONObject josnObjectResult = (JSONObject) jsonArray.get(0);
            String vesselName = (String) josnObjectResult.get("Vessel_Name");
            String inmarsat = (String) josnObjectResult.get("inmarsat");
            String inVoy = (String) josnObjectResult.get("IN_VOY");
            String outVoy = (String) josnObjectResult.get("OUT_VOY");
            String etd = (String) josnObjectResult.get("ETD");
            System.out.println("船名：" + vesselName + "\n航次：" + inmarsat + "\n订舱单号：" + inVoy + "\n航次：" + outVoy + "\n订舱单号：" + etd);
        }
        System.out.println(ajaxResultStr);
    }
}
