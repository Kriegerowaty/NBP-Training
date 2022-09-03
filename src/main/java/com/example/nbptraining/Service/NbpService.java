package com.example.nbptraining.Service;

import com.example.nbptraining.Entity.NbpEntity;
import com.example.nbptraining.Repository.NbpRepository;
import com.example.nbptraining.Xml.ArrayOfGoldPrice;
import com.example.nbptraining.Xml.ExchangeRatesSeries;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class NbpService {
    final NbpRepository nbpRepository;

    public NbpService(NbpRepository nbpRepository) { this.nbpRepository = nbpRepository; }


    public String calculateGold(String currency, String startDate, String endDate) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        NbpEntity nbpEntity = new NbpEntity();
        RestTemplate restTemplate = new RestTemplate();
        float currencyPrice = 1;
        float avgGoldPrice = 0;

        currency = currency.toUpperCase();

        String nbpGoldPrice = "https://api.nbp.pl/api/cenyzlota/"+startDate+"/"+endDate+"?format=xml";
        String nbpCurrency = "https://api.nbp.pl/api/exchangerates/rates/A/"+currency+"?format=xml";

        ResponseEntity<String> responseGold = restTemplate.getForEntity(nbpGoldPrice, String.class);
        String goldXML = responseGold.getBody();

        if(!currency.equals("PLN")) {
            ResponseEntity<String> responseCurrency = restTemplate.getForEntity(nbpCurrency, String.class);
            String currencyXML = responseCurrency.getBody();
            ExchangeRatesSeries exchangeRatesSeries = xmlMapper.readValue(currencyXML, ExchangeRatesSeries.class);
            currencyPrice = exchangeRatesSeries.getCurrencyCourse();
        }

        ArrayOfGoldPrice arrayOfGoldPrice = xmlMapper.readValue(goldXML, ArrayOfGoldPrice.class);
        avgGoldPrice = arrayOfGoldPrice.getAvgGoldPrice(currencyPrice);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        nbpEntity = new NbpEntity(currency, startDate, endDate, avgGoldPrice, dateTimeFormatter.format(now));

        return nbpRepository.save(nbpEntity).toString();
    }
    public String getID(long id) { return nbpRepository.findById(id).get().toString(); }
}
