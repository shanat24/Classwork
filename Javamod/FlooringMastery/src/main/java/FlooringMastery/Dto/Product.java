

package FlooringMastery.Dto;

import java.math.BigDecimal;

/**
 *
 * @author Shantoria Taylor 

 */
public class Product {
    
     private String productType;
     
    private BigDecimal materialCostPerSquareFoot;
    
    private BigDecimal laborCostPerSquareFoot;
    
    

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getMaterialCostPerSquareFoot() {
        return materialCostPerSquareFoot;
    }

    public void setMaterialCostPerSquareFoot(BigDecimal materialCostPerSquareFoot) {
        this.materialCostPerSquareFoot = materialCostPerSquareFoot;
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    public void setLaborCostPerSquareFoot(BigDecimal laborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }


}
