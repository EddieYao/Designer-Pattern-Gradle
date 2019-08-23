package util.webservice;

import javax.xml.bind.annotation.*;


/**
 * <p>anonymous complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ManifestShipInfoResult" type="{http://tempuri.org/}ArrayOfShipInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "manifestShipInfoResult"
})
@XmlRootElement(name = "ManifestShipInfoResponse")
public class ManifestShipInfoResponse {

    @XmlElement(name = "ManifestShipInfoResult")
    protected ArrayOfShipInfo manifestShipInfoResult;

    /**
     * 获取manifestShipInfoResult属性的值。
     *
     * @return
     *     possible object is
     *     {@link ArrayOfShipInfo }
     *
     */
    public ArrayOfShipInfo getManifestShipInfoResult() {
        return manifestShipInfoResult;
    }

    /**
     * 设置manifestShipInfoResult属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link ArrayOfShipInfo }
     *
     */
    public void setManifestShipInfoResult(ArrayOfShipInfo value) {
        this.manifestShipInfoResult = value;
    }

}
