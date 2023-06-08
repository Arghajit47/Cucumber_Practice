package AmazonImplimentation;

public class Search {
    public String displayProduct(Product product) {
        if(product.getProductList().contains(product.getName())) {
            return product.getName();
        }
        return null;
    }
}
