package claw.scctcn;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.util.StringUtils;
import util.httpClientUtils.HttpClientUtil;

public class ScctcnMain {
    /*
     * 测试账号密码
     */

    public static String url = "https://eportapisct.scctcn.com/api/GContainerInfo?System=&ContainerNo=TCLU4926045&PageIndex=1&PageSize=30&SortBy=&IsDescending=false";
    public static String url2 = "https://eportapisct.scctcn.com/api/VGMQueryByContainerNoInfo?ContainerNo=TCLU4926045&PageIndex=1&PageSize=30&SortBy=&IsDescending=false";

    public static void main(String[] args) {
        ContainerBodyResponse response = ScctnInfoUtil.queryBoxInformation("TCLU4926045");
        try {
            //实例化接口
            HttpClientUtil clientUtil = new HttpClientUtil();
            String ajaxResultStr = clientUtil.executeByGET(url);
            JSONObject jsonObject = (JSONObject) JSONObject.parse(ajaxResultStr);
            JSONArray jsonArray = (JSONArray) jsonObject.get("InnerList");

            String ajaxResultStr2 = clientUtil.executeByGET(url);
            JSONObject jsonObject2 = (JSONObject) JSONObject.parse(ajaxResultStr2);
            JSONArray jsonArray2 = (JSONArray) jsonObject2.get("InnerList");
            if (CollectionUtils.isNotEmpty(jsonArray)) {
                JSONObject jsonObjectResult = (JSONObject) jsonArray.get(0);
                // 船名
                String shipName = (String) jsonObjectResult.get("Avesselname");
                // 航次号
                String journey = (String) jsonObjectResult.get("OutBusinessVoy");
                if (StringUtils.isEmpty(journey)) {
                    journey = (String) jsonObjectResult.get("Outboundvoy");
                }
                // 箱主 (需转换)
                String carrierId = (String) jsonObjectResult.get("LineId");
                // 封条号
                String sealNo = (String) jsonObjectResult.get("SealNbr1");
                // 订舱单号
                String bookingNo = (String) jsonObjectResult.get("BookingEdo");
                // 卸货港
                String unloadingLocation = (String) jsonObjectResult.get("PodAlias");
                // 箱型尺寸
                String unloadicharacteristicCode = ((String) jsonObjectResult.get("SzTpHt")).substring(0, 5).replace("/", "");
                // IMO
                String imo = ((String) jsonObjectResult.get("IMO"));
                // 港口 SCT / CCT
                String port = ((String) jsonObjectResult.get("DbId"));
                if (StringUtils.isEmpty(port)) {
                    port = ((String) jsonObjectResult.get("dbid"));
                }
                System.out.println(shipName + "\n" + journey + "\n" + port + "\n" + carrierId + "\n" + sealNo + "\n" + bookingNo + "\n" + unloadingLocation + "\n" + unloadicharacteristicCode + "\n" + imo + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
