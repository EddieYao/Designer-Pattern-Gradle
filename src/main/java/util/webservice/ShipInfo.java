package util.webservice;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ShipInfo complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="ShipInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShipNameEn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShipNameCn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VoyageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AgentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Imo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LoadPortId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArrivalDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepartrueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CutoffDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Carrier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DataPlatform" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipInfo", propOrder = {
        "shipNameEn",
        "shipNameCn",
        "voyageCode",
        "agentId",
        "imo",
        "loadPortId",
        "arrivalDate",
        "departrueDate",
        "cutoffDate",
        "carrier",
        "dataPlatform",
        "status"
})
public class ShipInfo {

    @XmlElement(name = "ShipNameEn")
    protected String shipNameEn;
    @XmlElement(name = "ShipNameCn")
    protected String shipNameCn;
    @XmlElement(name = "VoyageCode")
    protected String voyageCode;
    @XmlElement(name = "AgentId")
    protected String agentId;
    @XmlElement(name = "Imo")
    protected String imo;
    @XmlElement(name = "LoadPortId")
    protected String loadPortId;
    @XmlElement(name = "ArrivalDate")
    protected String arrivalDate;
    @XmlElement(name = "DepartrueDate")
    protected String departrueDate;
    @XmlElement(name = "CutoffDate")
    protected String cutoffDate;
    @XmlElement(name = "Carrier")
    protected String carrier;
    @XmlElement(name = "DataPlatform")
    protected String dataPlatform;
    @XmlElement(name = "Status")
    protected String status;

    /**
     * 获取shipNameEn属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getShipNameEn() {
        return shipNameEn;
    }

    /**
     * 设置shipNameEn属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setShipNameEn(String value) {
        this.shipNameEn = value;
    }

    /**
     * 获取shipNameCn属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getShipNameCn() {
        return shipNameCn;
    }

    /**
     * 设置shipNameCn属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setShipNameCn(String value) {
        this.shipNameCn = value;
    }

    /**
     * 获取voyageCode属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVoyageCode() {
        return voyageCode;
    }

    /**
     * 设置voyageCode属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVoyageCode(String value) {
        this.voyageCode = value;
    }

    /**
     * 获取agentId属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     * 设置agentId属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAgentId(String value) {
        this.agentId = value;
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
     * 获取loadPortId属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLoadPortId() {
        return loadPortId;
    }

    /**
     * 设置loadPortId属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLoadPortId(String value) {
        this.loadPortId = value;
    }

    /**
     * 获取arrivalDate属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getArrivalDate() {
        return arrivalDate;
    }

    /**
     * 设置arrivalDate属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setArrivalDate(String value) {
        this.arrivalDate = value;
    }

    /**
     * 获取departrueDate属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDepartrueDate() {
        return departrueDate;
    }

    /**
     * 设置departrueDate属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDepartrueDate(String value) {
        this.departrueDate = value;
    }

    /**
     * 获取cutoffDate属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCutoffDate() {
        return cutoffDate;
    }

    /**
     * 设置cutoffDate属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCutoffDate(String value) {
        this.cutoffDate = value;
    }

    /**
     * 获取carrier属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCarrier() {
        return carrier;
    }

    /**
     * 设置carrier属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCarrier(String value) {
        this.carrier = value;
    }

    /**
     * 获取dataPlatform属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDataPlatform() {
        return dataPlatform;
    }

    /**
     * 设置dataPlatform属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDataPlatform(String value) {
        this.dataPlatform = value;
    }

    /**
     * 获取status属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置status属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
