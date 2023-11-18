import java.util.*;

class Shop {
    String name;
    double up;
    double gst;
    int quantity;

    public Shop(String name, double up, double gst, int quantity) {
        this.name = name;
        this.up = up;
        this.gst = gst;
        this.quantity = quantity;
    }

    public double DiscountPrice() {
        double discountPrice = up * quantity;
        if (up >= 500) {
            discountPrice *= 0.95;
        }
        return discountPrice;
    }

    public double GSTAmount() {
        return (up * gst / 100) * quantity;
    }
}

public class TestV {
    public static void main(String[] args) {
        List<Shop> basket = new ArrayList<>();
        basket.add(new Shop("Leather Wallet", 1100, 18, 1));
        basket.add(new Shop("Umbrella", 900, 12, 4));
        basket.add(new Shop("Cigarette", 200, 28, 3));
        basket.add(new Shop("Honey", 100, 0, 2));

        Shop maxGstProduct = MaxGST(basket);
        System.out.println("Product with maximum GST amount: " + maxGstProduct.name);

        double TotalAmount = AmountToPay(basket);
        System.out.println("Total amount to be paid to the shopkeeper: Rs" + TotalAmount);
    }
    
    private static double AmountToPay(List<Shop> basket) {
        double totalAmt = 0;

        for (Shop product : basket) {
            totalAmt += product.DiscountPrice() + product.GSTAmount();
        }

        return totalAmt;
    }
    
    private static Shop MaxGST(List<Shop> basket) {
        double maxGSTAmount = 0;
        Shop maxGstProduct = null;

        for (Shop product : basket) {
            double gstAmt = product.GSTAmount();
            if (gstAmt > maxGSTAmount) {
                maxGSTAmount = gstAmt;
                maxGstProduct = product;
            }
        }

        return maxGstProduct;
    }


}

