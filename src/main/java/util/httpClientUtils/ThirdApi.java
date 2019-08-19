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
    public static String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<Manifest>\n" +
            "  <Declaration>\n" +
            "    <ReceiveFirmCode>West</ReceiveFirmCode>\n" +
            "    <RepresentativePerson>\n" +
            "      <Name>5304279278578</Name>\n" +
            "    </RepresentativePerson>\n" +
            "    <ExitCustomsOffice>\n" +
            "      <ID>CNSHK/5304</ID>\n" +
            "    </ExitCustomsOffice>\n" +
            "    <Agent>\n" +
            "      <ID>5304279278578</ID>\n" +
            "    </Agent>\n" +
            "    <Carrier>\n" +
            "      <ID>CNC</ID>\n" +
            "    </Carrier>\n" +
            "    <BorderTransportMeans>\n" +
            "      <JourneyID>0QA3PS1NC</JourneyID>\n" +
            "      <TypeCode>1</TypeCode>\n" +
            "      <ID>UN9622007</ID>\n" +
            "      <Name>X-PRESS JERSEY</Name>\n" +
            "    </BorderTransportMeans>\n" +
            "    <Consignment>\n" +
            "      <TransportContractDocument>\n" +
            "        <ConditionCode>11</ConditionCode>\n" +
            "      </TransportContractDocument>\n" +
            "      <LoadingLocation>\n" +
            "        <ID>CNSHK/5304</ID>\n" +
            "        <LoadingDate>20190805080000</LoadingDate>\n" +
            "      </LoadingLocation>\n" +
            "      <UnloadingLocation><ID>IDJKT</ID></UnloadingLocation>\n" +
            "      <BookingNumber>D001-0103</BookingNumber>\n" +
            "      <CustomsStatusCode>001</CustomsStatusCode>\n" +
            "      <FreightPayment>\n" +
            "        <MethodCode>PP</MethodCode>\n" +
            "      </FreightPayment>\n" +
            "      <ConsignmentPackaging>\n" +
            "        <QuantityQuantity>11</QuantityQuantity>\n" +
            "        <TypeCode>CS</TypeCode>\n" +
            "      </ConsignmentPackaging>\n" +
            "      <DeclType>Q</DeclType>\n" +
            "      <TradeMode>0110</TradeMode>\n" +
            "      <HsCode>8413200000</HsCode>\n" +
            "      <MainGName>打头机</MainGName>\n" +
            "      <TotalGrossMassMeasure>18120</TotalGrossMassMeasure>\n" +
            "      <GrossVolumeMeasure></GrossVolumeMeasure>\n" +
            "<IF_BULK>0</IF_BULK>\n" +
            "<IF_COLD_STORAGE>0</IF_COLD_STORAGE>\n" +
            "<IF_TAXRET>0</IF_TAXRET>\n" +
            "<TRANS_START_PLACE></TRANS_START_PLACE>\n" +
            "<TRANS_TARGET_PLACE></TRANS_TARGET_PLACE>\n" +
            "      <Consignee>\n" +
            "        <ID>CIK+1234567890</ID>\n" +
            "        <Name><![CDATA[CV. AKS JAKARTA]]></Name>\n" +
            "        <Address>\n" +
            "          <Line>印度尼西亚</Line>\n" +
            "          <CityName></CityName>\n" +
            "          <CountrySubEntityID></CountrySubEntityID>\n" +
            "          <CountrySubEntityName></CountrySubEntityName>\n" +
            "          <PostcodeID></PostcodeID>\n" +
            "          <CountryCode>ID</CountryCode>\n" +
            "        </Address>\n" +
            "        <Communication>\n" +
            "<ID>12345678</ID>\n" +
            "<TypeID>TE</TypeID>\n" +
            "</Communication>\n" +
            "        <Contact>\n" +
            "          <Name></Name>\n" +
            "        </Contact>\n" +
            "        <AEO></AEO>\n" +
            "      </Consignee>\n" +
            "      <Consignor>\n" +
            "        <ID>USCI+123456789012345678</ID>\n" +
            "        <Name>深圳电器XXX有限公司</Name>\n" +
            "        <Address>\n" +
            "          <Line>深圳</Line>\n" +
            "          <CityName></CityName>\n" +
            "          <CountrySubEntityID></CountrySubEntityID>\n" +
            "          <CountrySubEntityName></CountrySubEntityName>\n" +
            "          <PostcodeID></PostcodeID>\n" +
            "          <CountryCode>CN</CountryCode>\n" +
            "        </Address>\n" +
            "        <Communication>\n" +
            "<ID>12345678</ID>\n" +
            "<TypeID>TE</TypeID>\n" +
            "</Communication>\n" +
            "        <AEO></AEO>\n" +
            "      </Consignor>\n" +
            "      <NotifyParty>\n" +
            "        <ID></ID>\n" +
            "        <Name><![CDATA[ANCDSAA]]></Name>\n" +
            "        <Address>\n" +
            "          <Line>印度尼西亚</Line>\n" +
            "          <CityName></CityName>\n" +
            "          <CountrySubEntityID></CountrySubEntityID>\n" +
            "          <CountrySubEntityName></CountrySubEntityName>\n" +
            "          <PostcodeID></PostcodeID>\n" +
            "          <CountryCode></CountryCode>\n" +
            "        </Address>\n" +
            "      </NotifyParty>\n" +
            "      <UNDGContact>\n" +
            "        <Name>阿五</Name>\n" +
            "        <Communication>\n" +
            "          <ID>13213213200</ID>\n" +
            "          <TypeID>TE</TypeID>\n" +
            "        </Communication>\n" +
            "      </UNDGContact>\n" +
            "      <ShipCompanyInfo>\n" +
            "        <ApplyType>3</ApplyType>\n" +
            "        <ZGCode></ZGCode>\n" +
            "        <Remark1>CCT</Remark1>\n" +
            "        <Remark2>0</Remark2>\n" +
            "        <Remark3>备注</Remark3>\n" +
            "        <Remark4>HSLWL_20190813090559</Remark4>\n" +
            "        <Remark5>HSLWL</Remark5>\n" +
            "        <ImoCode>UN9622007</ImoCode>\n" +
            "        <VoyNo>0QA3PS1NC</VoyNo>\n" +
            "        <AgencyCode>5304279278578</AgencyCode>\n" +
            "      </ShipCompanyInfo>\n" +
            "      <TransportEquipment>\n" +
            "        <EquipmentIdentification>\n" +
            "          <ID>PPWA0612006</ID>\n" +
            "        </EquipmentIdentification>\n" +
            "        <CharacteristicCode>40GP</CharacteristicCode>\n" +
            "        <SupplierPartyTypeCode>2</SupplierPartyTypeCode>\n" +
            "        <FullnessCode>5</FullnessCode>\n" +
            "        <SealID AgencyCode=\"CA\">E/001001</SealID>\n" +
            "        <FreightSpace>D001-0103</FreightSpace>\n" +
            "        <Remark></Remark>\n" +
            "      </TransportEquipment>\n" +
            "      <ConsignmentItem>\n" +
            "        <SequenceNumeric>1</SequenceNumeric>\n" +
            "        <ConsignmentItemPackaging>\n" +
            "          <QuantityQuantity>11</QuantityQuantity>\n" +
            "          <TypeCode>CS</TypeCode>\n" +
            "          <MarksNumbers>N/M</MarksNumbers>\n" +
            "        </ConsignmentItemPackaging>\n" +
            "        <Commodity>\n" +
            "          <CargoDescription><![CDATA[打头机]]></CargoDescription>\n" +
            "        </Commodity>\n" +
            "        <GoodsMeasure>\n" +
            "          <GrossMassMeasure>18120</GrossMassMeasure>\n" +
            "        </GoodsMeasure>\n" +
            "        <EquipmentIdentification>\n" +
            "          <ID>PPWA0612006</ID>\n" +
            "        </EquipmentIdentification>\n" +
            "      </ConsignmentItem>\n" +
            "    </Consignment>\n" +
            "  </Declaration>\n" +
            "</Manifest>\n";
    /**
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
