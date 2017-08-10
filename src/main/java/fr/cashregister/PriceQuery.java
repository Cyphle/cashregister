package fr.cashregister;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class PriceQuery {
  private final ItemReference[] itemItemReferences;

  public PriceQuery(ItemReference... itemItemReferences) {
    this.itemItemReferences = itemItemReferences;
  }

  public Result findPrice(String soughtItemCode) {
    return reduce(Result.notFound(soughtItemCode),
            (result, itemReference) -> Result.found(itemReference.getUnitPrice()),
            filter(itemReference -> itemReference.matchSoughtItemCode(soughtItemCode), Arrays.asList(itemItemReferences)));
  }

  public <T> List<T> filter(Predicate<T> predicate, Iterable<T> elements) {
    return reduce(new ArrayList<>(),
            (accumulator, element) -> predicate.test(element) ? append(accumulator, element) : accumulator,
            elements);
  }

  public <R, T> R reduce(R identity, BiFunction<R, T, R> f, Iterable<T> elements) {
    R result = identity;
    for (T element : elements) {
      result = f.apply(result, element);
    }
    return result;
  }

  public <T extends List<R>, R> T append(T accumulator, R element) {
    accumulator.add(element);
    return accumulator;
  }
}
