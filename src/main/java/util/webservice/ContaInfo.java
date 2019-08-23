package util.webservice;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ContaInfo complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="ContaInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TerminalBillNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Carrier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SizeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContaType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContaSize" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnloadPort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShipName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VoyNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DockCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContaId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Imo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LockNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "ContaInfo", propOrder = {
        "terminalBillNo",
        "carrier",
        "sizeType",
        "contaType",
        "contaSize",
        "unloadPort",
        "shipName",
        "voyNo",
        "dockCode",
        "contaId",
        "imo",
        "lockNo",
        "status"
})
public class ContaInfo {

    @XmlElement(name = "TerminalBillNo")
    protected String terminalBillNo;
    @XmlElement(name = "Carrier")
    protected String carrier;
    @XmlElement(name = "SizeType")
    protected String sizeType;
    @XmlElement(name = "ContaType")
    protected String contaType;
    @XmlElement(name = "ContaSize")
    protected String contaSize;
    @XmlElement(name = "UnloadPort")
    protected String unloadPort;
    @XmlElement(name = "ShipName")
    protected String shipName;
    @XmlElement(name = "VoyNo")
    protected String voyNo;
    @XmlElement(name = "DockCode")
    protected String dockCode;
    @XmlElement(name = "ContaId")
    protected String contaId;
    @XmlElement(name = "Imo")
    protected String imo;
    @XmlElement(name = "LockNo")
    protected String lockNo;
    @XmlElement(name = "Status")
    protected String status;

    /**
     * 获取terminalBillNo属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTerminalBillNo() {
        return terminalBillNo;
    }

    /**
     * 设置terminalBillNo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTerminalBillNo(String value) {
        this.terminalBillNo = value;
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
     * 获取sizeType属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSizeType() {
        return sizeType;
    }

    /**
     * 设置sizeType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSizeType(String value) {
        this.sizeType = value;
    }

    /**
     * 获取contaType属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContaType() {
        return contaType;
    }

    /**
     * 设置contaType属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContaType(String value) {
        this.contaType = value;
    }

    /**
     * 获取contaSize属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContaSize() {
        return contaSize;
    }

    /**
     * 设置contaSize属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContaSize(String value) {
        this.contaSize = value;
    }

    /**
     * 获取unloadPort属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUnloadPort() {
        return unloadPort;
    }

    /**
     * 设置unloadPort属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUnloadPort(String value) {
        this.unloadPort = value;
    }

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
     * 获取dockCode属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDockCode() {
        return dockCode;
    }

    /**
     * 设置dockCode属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDockCode(String value) {
        this.dockCode = value;
    }

    /**
     * 获取contaId属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContaId() {
        return contaId;
    }

    /**
     * 设置contaId属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContaId(String value) {
        this.contaId = value;
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
     * 获取lockNo属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLockNo() {
        return lockNo;
    }

    /**
     * 设置lockNo属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLockNo(String value) {
        this.lockNo = value;
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
