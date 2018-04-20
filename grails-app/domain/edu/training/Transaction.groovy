package edu.training

class Transaction {

    TransactionClassification classification
    Date dateCreated
    Date lastUpdated
    User user


    static belongsTo = [User]


    static constraints = {
        classification(nullable: false)
        user(nullable: false)
//        dateCreated(nullable: false)
//        lastUpdated(nullable: false)
    }

    static mapping = {
        tablePerHierarchy false
    }
}
