package edu.training

class Post extends Transaction {

    String content

    static hasMany = [tags:Tag]


    static constraints = {
        content(blank: false,maxSize: 1024)
    }

}
