package business.logic.account.discount;

public class DiscountFactory {
   public IDiscount getDiscount(String name) {
        switch(name)
        {
            case "Bronze":
                return new BronzeDiscount();
            case "Silver":
                return new SilverDiscount();
            case "Gold":
                return new GoldDiscount();
            default:
                return null;
        }
    }
}
