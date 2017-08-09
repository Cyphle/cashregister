package fr.cashregister;

final class Price {
  private final double amount;

  static Price valueOf(double amount) {
    return new Price(amount);
  }

  private Price(double amount) {
    this.amount = amount;
  }

  public double getAmount() {
    return amount;
  }

  public Price multiplyBy(double quantity) {
    return valueOf(amount * quantity);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Price price = (Price) o;
    return Double.compare(price.amount, amount) == 0;
  }

  @Override
  public int hashCode() {
    long temp = Double.doubleToLongBits(amount);
    return (int) (temp ^ (temp >>> 32));
  }

  @Override
  public String toString() {
    return "Price{" +
        "amount=" + amount +
        '}';
  }
}
