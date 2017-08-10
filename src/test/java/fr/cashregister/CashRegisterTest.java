package fr.cashregister;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static fr.cashregister.ItemReference.aReference;
import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class CashRegisterTest {
  private CashRegister cashRegister;
  private PriceQuery priceQuery;

  @Before
  public void setUp() throws Exception {
    this.cashRegister = new CashRegister();
    priceQuery = new PriceQuery(
            aReference().withItemCode("APPLE").withUnitPrice(1.20).build(),
            aReference().withItemCode("BANANA").withUnitPrice(1.90).build());
  }

  @Parameters({"APPLE, 1, 1.20", "APPLE, 2, 1.20", "BANANA, 10, 1.90"})
  @Test
  public void should_calculate_total_is_product_of_quantity_by_item_price_corresponding_to_existing_item_code(String itemCode, double quantity, double unitPrice) {
    Result total = cashRegister.total(priceQuery.findPrice(itemCode), Quantity.valueOf(quantity));
    assertThat(total).isEqualTo(Result.found(Price.valueOf(quantity*unitPrice)));
  }

  @Test
  public void should_calculate_total_not_found_when_item_price_not_found() {
    Result total = cashRegister.total(priceQuery.findPrice("PEACH"), Quantity.valueOf(1));
    assertThat(total).isEqualTo(Result.notFound("PEACH"));
  }
}
