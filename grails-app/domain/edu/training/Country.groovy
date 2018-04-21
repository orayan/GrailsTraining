package edu.training

class Country {

    String code
    String name

    static constraints = {
        code(nullable: false,blank: false,unique: true,size: 2..10,validator: {val,obj,errors->
            if(val == "il"){
                errors.reject("code.error.null")
            }
        })

        name(nullable: false,blank: false,validator: {val,obj->
            if (val.toLowerCase().contains("israel") ) {
                return ['countryNotValid',val]
            }
        })
    }
}
