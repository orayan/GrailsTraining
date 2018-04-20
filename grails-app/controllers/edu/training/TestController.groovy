package edu.training

class TestController {

    def index() {
        redirect(action:"demo")
    }


    def demo = {

        Country country = Country.findByCode("ps")



        if(!country) {
            country = new Country()

            country.code = "ps"
            country.name = "Palestine"

            country.save(flush:true)
        }else{
            country.name = "ps"
            country.name = "Palestine55"

            country.save(flush:true)
        }

        println(country.errors)

        respond country

    }
}
