package fr.cashregister;
import java.util.Arrays;

public class PriceQuery {
  private ItemReference[] itemItemReferences;

  public PriceQuery(ItemReference... itemItemReferences) {
    this.itemItemReferences = itemItemReferences;
  }

  public Price findPrice(String soughtItemCode) {
    for (ItemReference itemReference : itemItemReferences) {
      if (itemReference.mathSoughtItemCode(soughtItemCode))
        return itemReference.getUnitPrice();
    }
    return null;
  }
}
