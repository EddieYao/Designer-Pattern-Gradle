package claw.scctcn;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import util.httpClientUtils.HttpClientUtil;

public class ScctcnMain {
    /*
     * 测试账号密码
     */
    public static String url = "https://eportapisct.scctcn.com/api/GContainerInfo?System=&";

    public static void main(String[] args) {

        try {
            url += "ContainerNo=NYKU9748420&PageIndex=1&PageSize=30&SortBy=&IsDescending=false";
            //实例化接口
            HttpClientUtil clientUtil = new HttpClientUtil();
            String ajaxResultStr = clientUtil.executeByGET(url);
            JSONObject jsonObject = (JSONObject) JSONObject.parse(ajaxResultStr);
            JSONArray jsonArray = (JSONArray) jsonObject.get("InnerList");
            if (CollectionUtils.isNotEmpty(jsonArray)) {
                JSONObject jsonObjectResult = (JSONObject) jsonArray.get(0);
                String shipName = (String) jsonObjectResult.get("Avesselname");
                String journey = (String) jsonObjectResult.get("OutBusinessVoy");
                String carrierId = (String) jsonObjectResult.get("LineId");
                String sealNo = (String) jsonObjectResult.get("SealNbr1");
                String bookingNo = (String) jsonObjectResult.get("BookingEdo");
                String unloadingLocation = (String) jsonObjectResult.get("PodAlias");
                String unloadicharacteristicCode = (String) jsonObjectResult.get("SzTpHt");
                System.out.println(shipName + "\t" + journey + "\t" + carrierId + "\t" + sealNo + "\t" + bookingNo + "\t" + unloadingLocation + "\t" + unloadicharacteristicCode + "\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
