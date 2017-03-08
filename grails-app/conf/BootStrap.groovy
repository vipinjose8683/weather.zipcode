import com.weather.zipcode.Weather

class BootStrap {

    def init = { servletContext ->
		Weather weather1 = new Weather()
        if (!weather1.save()){
                log.error "Could not save weather1!!"
                log.error "${weather1.errors}"
        }
    }
	
    def destroy = {
    }
}
