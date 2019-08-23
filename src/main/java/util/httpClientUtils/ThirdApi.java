package util.httpClientUtils;



import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yongqiangyao
 * @description 录入接口
 */
public class ThirdApi {
    /**
     * 测试xml
     */
    public static String xml = " <?xml version=\"1.0\" encoding=\"UTF-8\"?><Mainfest> <Declaration> <ReceiveFirmCode></ReceiveFirmCode> <RepresentativePerson/> <Agent/> <Carrier> <ID>OOCL</ID> </Carrier> <BorderTransportMeans> <Name>OOCL KAOHSIUNG</Name> <JourneyID>100E</JourneyID> <TypeCode>2</TypeCode> <ID>UN9307009</ID> </BorderTransportMeans> <Consignment> <TransportContractDocument/> <LoadingLocation> <LoadingDate>20190823141428</LoadingDate> </LoadingLocation> <UnloadingLocation> <ID>NGBON</ID> </UnloadingLocation> <BookingNumber>2106563570</BookingNumber> <FreightPayment/> <ConsignmentPackaging> <QuantityQuantity>1805</QuantityQuantity> <TypeCode>CT</TypeCode> </ConsignmentPackaging> <DeclType>Q</DeclType> <TradeMode>0615</TradeMode> <MainGName>电热咖啡壶</MainGName> <TotalGrossMassMeasure>7039.5000</TotalGrossMassMeasure> <IF_BULK>0</IF_BULK> <IF_COLD_STORAGE>0</IF_COLD_STORAGE> <IF_TAXRET>0</IF_TAXRET> <Consignee> <ID>9999+39314640-000-01-18-8</ID> <Name>Good Cheer LLC</Name> <Communication> <TypeID>TE</TypeID> <ID>852-23978533</ID> </Communication> <Address> <Line>香港九龍尖沙咀漆咸道南17-19號11樓</Line> <CountryCode>HK</CountryCode> </Address> <AEO></AEO> </Consignee> <Consignor> <ID>USCI+91440000617653845D</ID> <Name>广东新宝电器股份有限公司</Name> <Communication> <TypeID>TE</TypeID> <ID>0757-25330250</ID> </Communication> <Address> <Line>佛山顺德</Line> <CountryCode>CN</CountryCode> </Address> <AEO></AEO> </Consignor> <NotifyParty> <ID></ID> <Name></Name> <Communication> <TypeID></TypeID> <ID></ID> </Communication> <Address> <Line></Line> </Address> </NotifyParty> <UNDGContact> <Name></Name> <Communication> <ID></ID> </Communication> </UNDGContact> <ShipCompanyInfo> <ApplyType>Q</ApplyType> <Remark1>CNYTN</Remark1> <ZGCode></ZGCode> <ImoCode>UN9307009</ImoCode> <VoyNo>100E</VoyNo> </ShipCompanyInfo>  <TransportEquipment> <EquipmentIdentification> <ID>RFCU4098544</ID> </EquipmentIdentification> <CharacteristicCode>40HQ</CharacteristicCode> <FullnessCode>5</FullnessCode> <BillSum>1</BillSum> <FreightSpace>2106563570</FreightSpace> </TransportEquipment>   <ConsignmentItem> <SequenceNumeric>0</SequenceNumeric> <ConsignmentItemPackaging> <QuantityQuantity>1805</QuantityQuantity> <TypeCode>CT</TypeCode> </ConsignmentItemPackaging> <Commodity> <CargoDescription>电热咖啡壶</CargoDescription> </Commodity> <GoodsMeasure> <GrossMassMeasure>7039.5000</GrossMassMeasure> </GoodsMeasure> <EquipmentIdentification> <ID>RFCU4098544</ID> </EquipmentIdentification> </ConsignmentItem> <ConsignmentItem> <SequenceNumeric>1</SequenceNumeric> <ConsignmentItemPackaging> <QuantityQuantity>1805</QuantityQuantity> <TypeCode>CT</TypeCode> </ConsignmentItemPackaging> <Commodity> <CargoDescription>电热咖啡壶</CargoDescription> </Commodity> <GoodsMeasure> <GrossMassMeasure>7039.5000</GrossMassMeasure> </GoodsMeasure> <EquipmentIdentification> <ID>RFCU4098544</ID> </EquipmentIdentification> </ConsignmentItem>  </Consignment> </Declaration> </Mainfest>" ;
     /*
      * 测试账号密码
     */
    public static String userName = "apitest";
    public static String passWord = "111111";
    public static String url = "http://outsite.szflow.com:40001/api/manifestapi/credentials";

    public static void main(String[] args) {

        try {
            Map<String, String> beanMap = new HashMap<>();
            beanMap.put("user_name", userName);
            beanMap.put("password", passWord);
            //实例化接口
            HttpClientUtil clientUtil = new HttpClientUtil();
            String ajaxResultStr = clientUtil.executeByPOST(url, beanMap);
            JSONObject jsonObject = (JSONObject)JSONObject.parse(ajaxResultStr);

            if ("1".equals(jsonObject.get("retCode").toString())){
                Map<String, String> beanMap2 = new HashMap<>();
                String token = (String)jsonObject.get("retMsg");
                beanMap2.put("token", token);
                beanMap2.put("xml", xml);
                String url2 = "http://outsite.szflow.com:40001/api/manifestapi/declaration";
                HttpClientUtil clientUtil2 = new HttpClientUtil();
                String ajaxResultStr2 = clientUtil2.executeByPOST(url2, beanMap2);
                JSONObject jsonObject2 = (JSONObject)JSONObject.parse(ajaxResultStr2);
                System.out.println(ajaxResultStr2);
            }
            System.out.println(ajaxResultStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
