package edu.training

import grails.gorm.transactions.Transactional

//service by default is transactional with write access and any transaction will be saved
@Transactional

class TestService {

    //transactional method - can write
    def test1(){

    }

    //just read data will raise exception if try to save
    @Transactional(readOnly = true)
    def test2(){

    }




    def test3(){

        User newUser

        //create with new session or new transaction to be used later
        //alternative is used flush:true
        User.withNewSession {
//        User.withNewTransaction {
            newUser = new User()
            newUser.save()
        }

        Profile newProfile = new Profile()
        newProfile.user = newUser
        newProfile.save()


    }


    def test4(){

        //not saved
        User.withTransaction {status->
            User newUser = new User()
            newUser.save()
            status.setRollbackOnly()
        }

        //saved
        User.withTransaction {status->
            User newUser = new User()
            newUser.save()
        }

    }


}
