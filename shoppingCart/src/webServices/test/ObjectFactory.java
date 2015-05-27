
package webServices.test;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webServices.test package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetProductByIdResponse_QNAME = new QName("http://webServices/", "getProductByIdResponse");
    private final static QName _GetAllProductsResponse_QNAME = new QName("http://webServices/", "getAllProductsResponse");
    private final static QName _GetProductById_QNAME = new QName("http://webServices/", "getProductById");
    private final static QName _AddProductResponse_QNAME = new QName("http://webServices/", "addProductResponse");
    private final static QName _AddProduct_QNAME = new QName("http://webServices/", "addProduct");
    private final static QName _RemoveProductByIdResponse_QNAME = new QName("http://webServices/", "removeProductByIdResponse");
    private final static QName _GetAllProducts_QNAME = new QName("http://webServices/", "getAllProducts");
    private final static QName _RemoveProductById_QNAME = new QName("http://webServices/", "removeProductById");
    private final static QName _Product_QNAME = new QName("http://webServices/", "product");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webServices.test
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllProducts }
     * 
     */
    public GetAllProducts createGetAllProducts() {
        return new GetAllProducts();
    }

    /**
     * Create an instance of {@link RemoveProductById }
     * 
     */
    public RemoveProductById createRemoveProductById() {
        return new RemoveProductById();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link RemoveProductByIdResponse }
     * 
     */
    public RemoveProductByIdResponse createRemoveProductByIdResponse() {
        return new RemoveProductByIdResponse();
    }

    /**
     * Create an instance of {@link AddProduct }
     * 
     */
    public AddProduct createAddProduct() {
        return new AddProduct();
    }

    /**
     * Create an instance of {@link AddProductResponse }
     * 
     */
    public AddProductResponse createAddProductResponse() {
        return new AddProductResponse();
    }

    /**
     * Create an instance of {@link GetProductByIdResponse }
     * 
     */
    public GetProductByIdResponse createGetProductByIdResponse() {
        return new GetProductByIdResponse();
    }

    /**
     * Create an instance of {@link GetProductById }
     * 
     */
    public GetProductById createGetProductById() {
        return new GetProductById();
    }

    /**
     * Create an instance of {@link GetAllProductsResponse }
     * 
     */
    public GetAllProductsResponse createGetAllProductsResponse() {
        return new GetAllProductsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "getProductByIdResponse")
    public JAXBElement<GetProductByIdResponse> createGetProductByIdResponse(GetProductByIdResponse value) {
        return new JAXBElement<GetProductByIdResponse>(_GetProductByIdResponse_QNAME, GetProductByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProductsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "getAllProductsResponse")
    public JAXBElement<GetAllProductsResponse> createGetAllProductsResponse(GetAllProductsResponse value) {
        return new JAXBElement<GetAllProductsResponse>(_GetAllProductsResponse_QNAME, GetAllProductsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "getProductById")
    public JAXBElement<GetProductById> createGetProductById(GetProductById value) {
        return new JAXBElement<GetProductById>(_GetProductById_QNAME, GetProductById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "addProductResponse")
    public JAXBElement<AddProductResponse> createAddProductResponse(AddProductResponse value) {
        return new JAXBElement<AddProductResponse>(_AddProductResponse_QNAME, AddProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "addProduct")
    public JAXBElement<AddProduct> createAddProduct(AddProduct value) {
        return new JAXBElement<AddProduct>(_AddProduct_QNAME, AddProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveProductByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "removeProductByIdResponse")
    public JAXBElement<RemoveProductByIdResponse> createRemoveProductByIdResponse(RemoveProductByIdResponse value) {
        return new JAXBElement<RemoveProductByIdResponse>(_RemoveProductByIdResponse_QNAME, RemoveProductByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProducts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "getAllProducts")
    public JAXBElement<GetAllProducts> createGetAllProducts(GetAllProducts value) {
        return new JAXBElement<GetAllProducts>(_GetAllProducts_QNAME, GetAllProducts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveProductById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "removeProductById")
    public JAXBElement<RemoveProductById> createRemoveProductById(RemoveProductById value) {
        return new JAXBElement<RemoveProductById>(_RemoveProductById_QNAME, RemoveProductById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Product }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "product")
    public JAXBElement<Product> createProduct(Product value) {
        return new JAXBElement<Product>(_Product_QNAME, Product.class, null, value);
    }

}
