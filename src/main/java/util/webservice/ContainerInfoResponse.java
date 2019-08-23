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
 *         &lt;element name="ContainerInfoResult" type="{http://tempuri.org/}ArrayOfContaInfo" minOccurs="0"/>
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
        "containerInfoResult"
})
@XmlRootElement(name = "ContainerInfoResponse")
public class ContainerInfoResponse {

    @XmlElement(name = "ContainerInfoResult")
    protected ArrayOfContaInfo containerInfoResult;

    /**
     * 获取containerInfoResult属性的值。
     *
     * @return
     *     possible object is
     *     {@link ArrayOfContaInfo }
     *
     */
    public ArrayOfContaInfo getContainerInfoResult() {
        return containerInfoResult;
    }

    /**
     * 设置containerInfoResult属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link ArrayOfContaInfo }
     *
     */
    public void setContainerInfoResult(ArrayOfContaInfo value) {
        this.containerInfoResult = value;
    }

}
