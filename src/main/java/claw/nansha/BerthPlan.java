package claw.nansha;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import util.httpClientUtils.HttpClientUtil;
import util.util.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BerthPlan {
    public static String berthPlanBeginUrl = "http://eportal.goct.com.cn/PublicInquire/BerthPlan/GetBerthPlan/?_dc=1570784544519&action=read&sDate=";
    public static String berthPlanEndUrl = "&page=1&start=0&limit=25";

    public static void main(String[] args) throws ParseException {
        HttpClientUtil clientUtil = new HttpClientUtil();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfTTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sDate = sdf.format(new Date());
        String eDate = sdf.format(DateUtil.getOffsiteDate(new Date(), Calendar.DAY_OF_MONTH, 7));

        System.out.println(sDate + "\n" + eDate);

        String ajaxResultStr = clientUtil.executeByGET(berthPlanBeginUrl + sDate + "&eDate=" + eDate + berthPlanEndUrl);
        System.out.println(berthPlanBeginUrl + sDate + "eDate=" + eDate + berthPlanEndUrl);
        JSONObject jsonObject = (JSONObject) JSONObject.parse(ajaxResultStr);
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        if (jsonArray != null && jsonArray.size() > 0) {
            List array = jsonArray.stream().filter(e -> (("MSC NAOMI").equals(((JSONObject)e).get("Vessel_Name")))).collect(Collectors.toList());
            JSONObject josnObjectResult = (JSONObject) array.get(0);
            String vesselName = (String) josnObjectResult.get("Vessel_Name");
            String inmarsat = (String) josnObjectResult.get("inmarsat");
            String inVoy = (String) josnObjectResult.get("IN_VOY");
            String outVoy = (String) josnObjectResult.get("OUT_VOY");
            String etd = (String) josnObjectResult.get("ETD");
            System.out.println("船名：" + vesselName + "\nimo：" + inmarsat + "\n进口航次号：" + inVoy + "\n出口航次号：" + outVoy + "\n预计开船日期：" + sdfTime.format(sdfTTime.parse(etd)));
        }
        System.out.println(ajaxResultStr);
    }
}
