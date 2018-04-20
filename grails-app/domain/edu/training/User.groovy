package edu.training

class User {

    String userId
    String password
    String homepage
    Date dateCreated
    Date lastUpdated

    Profile profile

    static belongsTo = [Profile]

//    static hasMany = [posts:Post,tags:Tag,following:User]
    static hasMany = [following:User,transactions:Transaction]

    static constraints = {
        userId(size: 3..20,unique: true)
        password(password:true,size: 6..8,validator:{val, obj, errors ->
        if (val == obj.userId) {
            errors.rejectValue('password', 'user.password.errorValue')
        }
        })
        homepage(url: true,nullable: true)
        profile(nullable: true)
    }

    static mapping = {
        table '`USER`'
        password column: '`password`'
        profile lazy: false //tell grails to load profile with user
    }
}
