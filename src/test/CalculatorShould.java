import com.danparkin.Calculator;
import com.danparkin.Currency;
import com.danparkin.Money;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class CalculatorShould {
    private Calculator calculator;

    private BigDecimal Commission = new BigDecimal(200);
    private BigDecimal SmallPackagePrice = new BigDecimal(120);
    private int MaximumSmallWeight = 60;
    private int MaximumSmallHeight = 229;
    private int MaximumSmallWidth = 162;
    private int MaximumSmallDepth = 25;
    private int MaximumMediumWeight = 500;
    private int MaximumMediumHeight = 324;
    private int MaximumMediumWidth = 229;
    private int MaximumMediumDepth = 100;
    private double GbpToEur = 1.25;
    private double GbpToChf = 1.36;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    private Object[] charge_a_flat_rate_for_a_small_package_params() {
        return new Object[]{
                new Object[]{1, 1, 1, 1},
                new Object[]{MaximumSmallWeight, 1, 1, 1},
                new Object[]{1, MaximumSmallHeight, 1, 1},
                new Object[]{1, 1, MaximumSmallWidth, 1},
                new Object[]{1, 1, 1, MaximumSmallDepth},
        };
    }

    @Test
    @Parameters(method = "charge_a_flat_rate_for_a_small_package_params")
    public void charge_a_flat_rate_for_a_small_package(int weight, int height, int width, int depth)
    {
        assertThat(calculator.Calculate(weight, height, width, depth, Currency.Gbp),
                is(new Money(Currency.Gbp, SmallPackagePrice)));
    }

    private Object[] price_a_medium_package_by_weight_params() {
        return new Object[]{
                new Object[]{MaximumSmallWeight + 1, 1, 1, 1},
                new Object[]{MaximumMediumWeight, 1, 1, 1},
                new Object[]{1, MaximumSmallHeight + 1, 1, 1},
                new Object[]{1, MaximumMediumHeight, 1, 1},
                new Object[]{1, 1, MaximumSmallWidth + 1, 1},
                new Object[]{1, 1, MaximumMediumWidth, 1},
                new Object[]{1, 1, 1, MaximumSmallDepth + 1},
                new Object[]{1, 1, 1, MaximumMediumDepth},
        };
    }

    @Test
    @Parameters(method = "price_a_medium_package_by_weight_params")
    public void price_a_medium_package_by_weight(int weight, int height, int width, int depth)
    {
        assertThat(calculator.Calculate(weight, height, width, depth, Currency.Gbp),
                is(new Money(Currency.Gbp, new BigDecimal(weight * 4))));
    }

    private Object[] price_a_large_heavy_package_by_weight_params() {
        return new Object[]{
                new Object[]{MaximumMediumWeight + 1, 1, 1, 1},
                new Object[]{1, MaximumMediumHeight + 1, 1, 1},
                new Object[]{1, 1, MaximumMediumWidth + 1, 1},
                new Object[]{1, 1, 1, MaximumMediumDepth + 1},
        };
    }

    @Test
    @Parameters(method = "price_a_large_heavy_package_by_weight_params")
    public void price_a_large_heavy_package_by_weight(int weight, int height, int width, int depth)
    {
        assertThat(calculator.Calculate(weight, height, width, depth, Currency.Gbp),
                is(new Money(Currency.Gbp, new BigDecimal(weight * 6))));
    }

    private Object[] price_a_large_light_package_by_volume_params() {
        return new Object[]{
                new Object[]{1, 1001, 1, 1},
                new Object[]{1, 1, 1001, 1},
                new Object[]{1, 1, 1, 1001},
        };
    }

    @Test
    @Parameters(method = "price_a_large_light_package_by_volume_params")
    public void price_a_large_light_package_by_volume(int weight, int height, int width, int depth)
    {
        assertThat(calculator.Calculate(weight, height, width, depth, Currency.Gbp),
                is(new Money(Currency.Gbp, new BigDecimal((height*width*depth/1000)*6))));
    }

    private Object[] add_commission_for_currency_other_than_gbp_params() {
        return new Object[]{
                new Object[]{Currency.Eur, GbpToEur},
                new Object[]{Currency.Chf, GbpToChf},
        };
    }

    @Test
    @Parameters(method = "add_commission_for_currency_other_than_gbp_params")
    public void add_commission_for_currency_other_than_gbp(Currency currency, double exchangeRate)
    {
        BigDecimal price = SmallPackagePrice.add(Commission).multiply(new BigDecimal(exchangeRate));
        assertThat(calculator.Calculate(20, 20, 20, 20, currency),
                is(new Money(currency, price)));
    }
}

