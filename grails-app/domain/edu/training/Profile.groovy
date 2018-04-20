package edu.training

class Profile {

    Byte[] photo

    String fullName
    String bio
    String email
    String timezone
    String address

    Integer age

    Date dateOfBirth

    String description

    Country country
    User user


    static transients = ['age']

    static belongsTo = [Country, User]

    static constraints = {
        photo(nullable: true)
        fullName(nullable: false,blank: false)
        bio(nullable: true,blank: false)
        email(nullable: true,blank: false,email: true)
        timezone(nullable: true,blank: false)
        address(nullable: true,blank: false)
        description(nullable: true,blank: true,widget:'textarea')
        country(nullable: false)
        user(nullable: false)
        dateOfBirth(nullable: false)
    }

    static mapping = {
        description type: 'text'
    }
}
