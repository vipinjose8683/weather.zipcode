import com.weather.zipcode.Weather

class BootStrap {

    def init = { servletContext ->
		Weather weather1 = new Weather()
		Weather weather2 = new Weather(zipCode:30064,temperature:64,iconUrl:"http://openweathermap.org/img/w/10d.png",description:"Mostly Cloudy",humidity:"90",windSpeed:"4")
		Weather weather3 = new Weather(zipCode:30339,temperature:68,iconUrl:"http://openweathermap.org/img/w/01d.png",description:"Clear",humidity:"10",windSpeed:"7")
        if (!weather1.save()){
                log.error "Could not save weather1!!"
                log.error "${weather1.errors}"
        }
        if (!weather2.save()){
                log.error "Could not save weather2!!"
                log.error "${weather2.errors}"
        }
        if (!weather3.save()){
                log.error "Could not save weather3!!"
                log.error "${weather3.errors}"
        }
    }
	
    def destroy = {
    }
}
