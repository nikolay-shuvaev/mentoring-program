package com.epam.shuvaev.web.services.task3.server;

import com.epam.shuvaev.web.services.task3.WeatherInCitiesResponse;
import com.epam.shuvaev.web.services.task3.WeatherInCity;
import eu.dataaccess.footballpool.ArrayOftPlayersWithCards;
import eu.dataaccess.footballpool.Info;
import eu.dataaccess.footballpool.InfoSoapType;
import eu.dataaccess.footballpool.TPlayersWithCards;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@WebService
public class FifaInfoWebService {
    private Info info = new Info();
    private GlobalWeather globalWeather = new GlobalWeather();

    @WebMethod
    public long cardOfTeam(@WebParam(name = "team") @XmlElement(required = true) String team) {
        InfoSoapType infoSoap = info.getInfoSoap();
        ArrayOftPlayersWithCards arrayOftPlayersWithCards
                = infoSoap.allPlayersWithYellowOrRedCards(true, false, false);
        return arrayOftPlayersWithCards.getTPlayersWithCards().stream()
                .map(TPlayersWithCards::getSTeamName)
                .filter(team::equals)
                .count();
    }

    @WebMethod
    public Set<String> getAllCountryWithCard() {
        InfoSoapType infoSoap = info.getInfoSoap();
        ArrayOftPlayersWithCards arrayOftPlayersWithCards
                = infoSoap.allPlayersWithYellowOrRedCards(true, false, false);
        return arrayOftPlayersWithCards.getTPlayersWithCards().stream()
                .map(TPlayersWithCards::getSTeamName)
                .collect(toSet());
    }

    @WebMethod()
    public WeatherInCitiesResponse weatherOfWMCities() {
        InfoSoapType infoSoap = info.getInfoSoap();
        List<String> listOfCities = infoSoap.cities().getString();

        WeatherInCitiesResponse weatherInCitiesResponse = new WeatherInCitiesResponse();
        weatherInCitiesResponse.setWeatherInCities(
                listOfCities.stream()
                    .map(this::getWeatherInCity)
                    .collect(toList())
        );

        return weatherInCitiesResponse;
    }

    private WeatherInCity getWeatherInCity(String city) {
        WeatherInCity weatherInCity = new WeatherInCity();
        weatherInCity.setCity(city);
        weatherInCity.setWeather(getWeather(city));
        return weatherInCity;
    }

    private String getWeather(String city) {
        GlobalWeatherSoap globalWeatherSoap = globalWeather.getGlobalWeatherSoap();
        return globalWeatherSoap.getWeather(city, "France");
    }
}
