package fr.cashregister;

public class Quantity {
  private double value;

  public static Quantity valueOf(double value) {
    return new Quantity(value);
  }

  private Quantity(double value) {
    this.value = value;
  }

  public double multiplyBy(double amount) {
    return value*amount;
  }
}
