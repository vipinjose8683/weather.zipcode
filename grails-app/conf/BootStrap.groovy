import com.weather.zipcode.Weather

class BootStrap {

    def init = { servletContext ->
		Weather weather1 = new Weather(zipCode:30064,temperature:64)
		Weather weather2 = new Weather(zipCode:30339,temperature:68)
        if (!weather1.save()){
                log.error "Could not save weather1!!"
                log.error "${weather1.errors}"
        }
        if (!weather2.save()){
                log.error "Could not save weather2!!"
                log.error "${weather2.errors}"
        }
    }
    def destroy = {
    }
}
