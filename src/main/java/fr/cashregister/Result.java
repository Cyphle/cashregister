package fr.cashregister;

abstract class Result {
  static Result found(Price price) {
    return new Found(price);
  }

  static Result notFound(String itemCode) {
    return new NotFound(itemCode);
  }

  private static class Found extends Result {
    private Price price;

    public Found(Price price) {
      super();
      this.price = price;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Found found = (Found) o;

      return price != null ? price.equals(found.price) : found.price == null;
    }

    @Override
    public int hashCode() {
      return price != null ? price.hashCode() : 0;
    }
  }

  private static class NotFound extends Result {
    private String itemCode;

    public NotFound(String itemCode) {
      super();
      this.itemCode = itemCode;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      NotFound notFound = (NotFound) o;

      return itemCode != null ? itemCode.equals(notFound.itemCode) : notFound.itemCode == null;
    }

    @Override
    public int hashCode() {
      return itemCode != null ? itemCode.hashCode() : 0;
    }
  }
}
