package util.webservice;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>ArrayOfContaInfo complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="ArrayOfContaInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContaInfo" type="{http://tempuri.org/}ContaInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfContaInfo", propOrder = {
        "contaInfo"
})
public class ArrayOfContaInfo {

    @XmlElement(name = "ContaInfo", nillable = true)
    protected List<ContaInfo> contaInfo;

    /**
     * Gets the value of the contaInfo property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contaInfo property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContaInfo().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContaInfo }
     *
     *
     */
    public List<ContaInfo> getContaInfo() {
        if (contaInfo == null) {
            contaInfo = new ArrayList<ContaInfo>();
        }
        return this.contaInfo;
    }

}
