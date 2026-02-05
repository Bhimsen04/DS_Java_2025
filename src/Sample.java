

public class Sample {

    /*
    trade_id, quantity, price, currency, cusip
    100 , 2, 200, USD, dfdfgg

    I/p -> INR
     */



}

/*
@RequestMapping("/currencyCont")
@RestController
public class CurrrencyController{

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/{currency}")
    public ResponseEntity<Currency> currencyConvertor(@PathVariable String currency){
        return ResponseEntity.ok(currencyService.currencyConvertor(currency));
    }

}

@Service
public class CurrencyService{

    @Autowired
    private CurrencyRepository currencyRepository;

    private Currency currencyConvertor(String currency){
        // Db call

        // sourceCurr , destCurr , price
        // USD, INR -> 100
        // USD, HKG -> 200
        // AUD, SIN -> 30
        // Trade = sourceCurr from downstreamApi
        double conversionRate = currencyRepository.getCurrencyConversionRate(trade.getSourceCurr(), currency);

        // trade_id, quantity, price, currency, cusip
        // 100 , 2, 200, USD, dfdfgg
        // 101 , 5, 1000, AUD, fhhfjhjr

        // conversionRate = 5

        double price = conversionRate * Trade.price();

        currencyObj.setPricr(price);
        currencyObj.setCurrency(currency);

        return currencyObj;

    }

}

@Service
public interface CurrencyRepository extends JPARepository<Currency, Long>{

    select conversionRate from currencyConveretr where sourceCurrency :{} and targetCurrency = ""
    public double getCurrencyConversionRate(String sourceCurrency, String targetCurrency);

    .set
}*/
