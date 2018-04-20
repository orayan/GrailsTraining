package edu.training

class Tag extends Transaction{

    String name
    Post post

    static belongsTo = [Post]

    static hasMany = [tagPosts:TagPost]

    static constraints = {
        name(blank: false,maxSize: 20)
        post(nullable: false)
    }

    static mapping = {
        version false
    }
}
