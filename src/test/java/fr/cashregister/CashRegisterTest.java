package fr.cashregister;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CashRegisterTest {
  @Test
  public void should_calculate_total_bill_when_giving_price_and_quantity() {
    CashRegister cashRegister = new CashRegister();
    Price price = Price.valueOf(1.20);
    double quantity = 1;
    Price total = cashRegister.total(price, quantity);
    assertThat(total).isEqualTo(Price.valueOf(1.20));
  }
}
