package claw.scctcn;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.util.StringUtils;
import util.httpClientUtils.HttpClientUtil;

/**
 * 蛇口港信息服务接口工具类
 *
 * @author willchen
 * @since 2019-08-02 13:44:44
 */
public class ScctnInfoUtil {
    
    public static String danxiangurl = "https://eportapisct.scctcn.com/api/GContainerInfo?System=&ContainerNo=";
    public static String VGMurl = "https://eportapisct.scctcn.com/api/VGMQueryByContainerNoInfo?ContainerNo=";
    public static String endUrl = "&PageIndex=1&PageSize=30&SortBy=&IsDescending=false";
    /**
     * 蛇口集装箱详情查询
     *
     * @param containerNo
     * @return
     */
    public static ContainerBodyResponse queryBoxInformation(String containerNo){
        ContainerBodyResponse response = new ContainerBodyResponse();
        //实例化接口
        HttpClientUtil clientUtil = new HttpClientUtil();
        String ajaxResultStr = clientUtil.executeByGET(danxiangurl+containerNo+endUrl);
        JSONObject jsonObject = (JSONObject) JSONObject.parse(ajaxResultStr);
        JSONArray jsonArray = (JSONArray) jsonObject.get("InnerList");

        String ajaxResultStrVGM = clientUtil.executeByGET(VGMurl+containerNo+endUrl);
        JSONObject jsonObjectVGM = (JSONObject) JSONObject.parse(ajaxResultStrVGM);
        JSONArray jsonArrayVGM = (JSONArray) jsonObjectVGM.get("InnerList");

        if (CollectionUtils.isNotEmpty(jsonArray)) {
            JSONObject jsonObjectResult = (JSONObject) jsonArray.get(0);
            // 船名
            response.setShipName((String)jsonObjectResult.get("Avesselname"));
            // 航次号
            String journey = (String) jsonObjectResult.get("OutBusinessVoy");
            if (StringUtils.isEmpty(journey)) {
                journey = (String) jsonObjectResult.get("Outboundvoy");
            }
            response.setJourneyID(journey);
            // 箱主 (需转换)
            String carrierId = (String) jsonObjectResult.get("LineId");
            // 特定箱主名转换
            if ("YMLK".equals(carrierId)) {
                carrierId = "YML";
            } else if ("OOCL".equals(carrierId)) {
                carrierId = "OOLN";
            } else if ("MSUS".equals(carrierId)) {
                carrierId = "MSC";
            }
            response.setCarrierID(carrierId);
            // 封条号
            response.setSealID((String) jsonObjectResult.get("SealNbr1"));
            // 订舱单号
            response.setBookingNumber((String)jsonObjectResult.get("BookingEdo"));
            // 卸货港
//            UnloadingLocation unloadingLocation = new UnloadingLocation();
//            unloadingLocation.setId((String)jsonObjectResult.get("PodAlias"));
//            response.setUnloadingLocation(unloadingLocation);
            // 箱型尺寸
            response.setCharacteristicCode(((String) jsonObjectResult.get("SzTpHt")).substring(0, 5).replace("/", ""));
            // IMO
            response.setIMO((String) jsonObjectResult.get("IMO"));
            // 港口 SCT / CCT
            String port = ((String) jsonObjectResult.get("DbId"));
            if (StringUtils.isEmpty(port)) {
                port = ((String) jsonObjectResult.get("dbid"));
            }
            response.setPort(port);
            response.setResult("001");
        }
        if (CollectionUtils.isNotEmpty(jsonArrayVGM)) {
            JSONObject jsonObjectResult = (JSONObject) jsonArray.get(0);

        }
        return response;
    }
}
