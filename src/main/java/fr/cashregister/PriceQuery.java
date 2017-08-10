package fr.cashregister;

public class PriceQuery {
  private final ItemReference[] itemItemReferences;

  public PriceQuery(ItemReference... itemItemReferences) {
    this.itemItemReferences = itemItemReferences;
  }

  public Result findPrice(String soughtItemCode) {
    for (ItemReference itemReference : itemItemReferences) {
      if (itemReference.mathSoughtItemCode(soughtItemCode))
        return Result.found(itemReference.getUnitPrice());
    }
    return Result.notFound(soughtItemCode);
  }
}
