package fr.cashregister;

import java.util.function.UnaryOperator;

abstract class Result {
  static Result found(Price price) {
    return new Found(price);
  }

  static Result notFound(String itemCode) {
    return new NotFound(itemCode);
  }

  abstract Result map(UnaryOperator<Price> unaryOperator);

  private static class Found extends Result {
    private Price price;

    public Found(Price price) {
      super();
      this.price = price;
    }

    @Override
    Result map(UnaryOperator<Price> unaryOperator) {
      return new Found(unaryOperator.apply(price));
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
    Result map(UnaryOperator<Price> unaryOperator) {
      return new NotFound(itemCode);
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
