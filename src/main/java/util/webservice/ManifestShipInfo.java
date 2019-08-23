package util.webservice;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="shipName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="voyNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="imo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wharf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="platform" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "shipName",
        "voyNo",
        "imo",
        "wharf",
        "platform"
})
@XmlRootElement(name = "ManifestShipInfo")
public class ManifestShipInfo {

    protected String shipName;
    protected String voyNo;
    protected String imo;
    protected String wharf;
    protected String platform;

    /**
     * 获取shipName属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getShipName() {
        return shipName;
    }

    /**
     * 设置shipName属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setShipName(String value) {
        this.shipName = value;
    }

    /**
     * 获取voyNo属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVoyNo() {
        return voyNo;
    }

    /**
     * 设置voyNo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVoyNo(String value) {
        this.voyNo = value;
    }

    /**
     * 获取imo属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getImo() {
        return imo;
    }

    /**
     * 设置imo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setImo(String value) {
        this.imo = value;
    }

    /**
     * 获取wharf属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWharf() {
        return wharf;
    }

    /**
     * 设置wharf属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWharf(String value) {
        this.wharf = value;
    }

    /**
     * 获取platform属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * 设置platform属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPlatform(String value) {
        this.platform = value;
    }

}
