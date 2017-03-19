package com.epam.shuvaev.web.services.task3;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Nikolay Shuvaev on 19.03.2017
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "allWeatherInCities", propOrder = {
        "weatherInCities"
})
@XmlRootElement(name = "allWeatherInCity")
public class WeatherInCitiesResponse {

    @XmlElement(name = "weatherInCitiesResult", required = true)
    private List<WeatherInCity> weatherInCities;

    public List<WeatherInCity> getWeatherInCities() {
        return weatherInCities;
    }

    public void setWeatherInCities(List<WeatherInCity> weatherInCities) {
        this.weatherInCities = weatherInCities;
    }
}
