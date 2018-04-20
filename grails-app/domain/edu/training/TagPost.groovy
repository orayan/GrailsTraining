package edu.training

class TagPost {

    Tag tag
    Post post

    static constraints = {
        tag(nullable: false)
        post(nullable: false)
    }
}
