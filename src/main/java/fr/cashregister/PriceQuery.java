package fr.cashregister;

public class PriceQuery {
  private final ItemReference[] itemItemReferences;

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
