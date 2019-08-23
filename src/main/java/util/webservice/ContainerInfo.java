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
 *         &lt;element name="containerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wharf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "containerId",
        "wharf"
})
@XmlRootElement(name = "ContainerInfo")
public class ContainerInfo {

    protected String containerId;
    protected String wharf;

    /**
     * 获取containerId属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContainerId() {
        return containerId;
    }

    /**
     * 设置containerId属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContainerId(String value) {
        this.containerId = value;
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

}
