
package webServices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "addProduct", namespace = "http://webServices/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addProduct", namespace = "http://webServices/")
public class AddProduct {

    @XmlElement(name = "arg0", namespace = "")
    private model.Product arg0;

    /**
     * 
     * @return
     *     returns Product
     */
    public model.Product getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(model.Product arg0) {
        this.arg0 = arg0;
    }

}
