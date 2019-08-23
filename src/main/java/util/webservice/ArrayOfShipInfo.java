package util.webservice;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>ArrayOfShipInfo complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="ArrayOfShipInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShipInfo" type="{http://tempuri.org/}ShipInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfShipInfo", propOrder = {
        "shipInfo"
})
public class ArrayOfShipInfo {

    @XmlElement(name = "ShipInfo", nillable = true)
    protected List<ShipInfo> shipInfo;

    /**
     * Gets the value of the shipInfo property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shipInfo property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShipInfo().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShipInfo }
     *
     *
     */
    public List<ShipInfo> getShipInfo() {
        if (shipInfo == null) {
            shipInfo = new ArrayList<ShipInfo>();
        }
        return this.shipInfo;
    }

}
