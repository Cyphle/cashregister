package fr.cashregister;

public class ItemReference {
  private final String itemCode;
  private final Price unitPrice;
  static ReferenceBuilder aReference() { return new ReferenceBuilder(); }

  public ItemReference(String itemCode, Price unitPrice) {
    this.itemCode = itemCode;
    this.unitPrice = unitPrice;
  }

  public Price getUnitPrice() {
    return unitPrice;
  }

  public boolean mathSoughtItemCode(String soughtItemCode) {
    return itemCode.equals(soughtItemCode);
  }

  static class ReferenceBuilder {
    private String itemCode;
    private Price unitPrice;

    private ReferenceBuilder() {
    }

    public ReferenceBuilder withItemCode(String itemCode) {
      this.itemCode = itemCode;
      return this;
    }

    public ReferenceBuilder withUnitPrice(double unitPrice) {
      this.unitPrice = Price.valueOf(unitPrice);
      return this;
    }

    public ItemReference build() {
      return new ItemReference(itemCode, unitPrice);
    }
  }
}
