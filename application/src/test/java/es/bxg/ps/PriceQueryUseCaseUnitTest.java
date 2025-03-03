package es.bxg.ps;

import es.bxg.ps.brand.model.Brand;
import es.bxg.ps.price.exception.PriceNotFoundException;
import es.bxg.ps.price.model.Price;
import es.bxg.ps.price.port.IPriceQueryPort;
import es.bxg.ps.price.usecase.PriceQueryUseCase;
import es.bxg.ps.pricelist.model.PriceList;
import es.bxg.ps.product.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PriceQueryUseCaseUnitTest {

  @InjectMocks
  private PriceQueryUseCase priceQueryUseCase;

  @Mock
  private IPriceQueryPort port;

  @Test
  public void findOneByDateOK() {

    Mockito.when(port.findByFilters(Mockito.any())).thenReturn(generatePriceList());

    Price result = priceQueryUseCase.findOneByDate(1L, 1L, OffsetDateTime.now());

    Assertions.assertEquals((short) 2, result.getPriority());
  }

  @Test
  public void findOneByDateKO() {

    Mockito.when(port.findByFilters(Mockito.any())).thenReturn(new ArrayList<>());

    Exception ex = Assertions.assertThrows(
        PriceNotFoundException.class,
        () -> priceQueryUseCase.findOneByDate(1L, 1L, OffsetDateTime.now()));

    Assertions.assertEquals("No hay precio definido para esa fecha", ex.getMessage());
  }

  private List<Price> generatePriceList() {
    List<Price> prices = new ArrayList<>();

    // Crear objetos ficticios para Brand, Product y PriceList
    Brand brand = Brand.builder().id(1L).name("Brand1").build();
    Product product = Product.builder().id(1L).name("Product1").build();
    PriceList priceList = PriceList.builder().id(1L).name("Price List 1").build();

    // Crear instancias de Price con valores ficticios
    Price price1 = Price.builder()
        .id(1L)
        .startDate(OffsetDateTime.now())
        .endDate(OffsetDateTime.now().plusDays(10))
        .priority((short) 2)
        .price(new BigDecimal("100.50"))
        .currency("EUR")
        .brand(brand)
        .product(product)
        .priceList(priceList)
        .build();

    Price price2 = Price.builder()
        .id(2L)
        .startDate(OffsetDateTime.now().plusDays(2))
        .endDate(OffsetDateTime.now().plusDays(15))
        .priority((short) 1)
        .price(new BigDecimal("200.99"))
        .currency("EUR")
        .brand(brand)
        .product(product)
        .priceList(priceList)
        .build();

    // Agregar las instancias al ArrayList
    prices.add(price1);
    prices.add(price2);

    return prices;
  }


}
