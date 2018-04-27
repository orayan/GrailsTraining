package edu.training

import groovy.sql.Sql

class TestController {

    def dataSource

    def index() {
        redirect(action:"list")
    }

    def list = {
        render "list"
    }


    def testError = {
        //create new instance
        Country country = new Country()

        //assign the code and name values
        country.code = "il"
        country.name = "IsraelCountry"

        //try to save the instance
        country.validate()

        if(country.hasErrors()){
            country.errors.rejectValue("name","country.custom.error",["Jordan","Palestine"] as Object[],"not save")
            country.errors.reject("country.custom.error2",["Jordan2","Palestine2"] as Object[],"not save")
        }else{
            country.save(flush:true,failOnError:true)
        }




        //it's important to add custom error after validate

        //view domain errors on terminal
        println(country.errors)

        //return a map to page with key equal the simple name of domain class like [country:country]
        respond country
    }


    def testQuery = {

        User userIns = User.findByUserId("ali")
        def postCriteria = Post.createCriteria()
        def sql = new Sql(dataSource)
        def queryResult


        //************** FINDER **************

//        queryResult = Transaction.list()
//        queryResult = Transaction.list(offset:10, max:20)
//        queryResult = Post.list(sort:"content", order:"asc")
//        queryResult = User.get(1)?.userId
//        queryResult = Transaction.count()
//        queryResult = Transaction.countByUser(userIns)


//        queryResult = Post.findByUser(userIns)
//        queryResult = Post.findAllByUser(userIns)
//        queryResult = Post.findByContentLike("post%")
//        queryResult = Profile.findByUserAndDateOfBirthBetween(userIns,new Date("16/08/1970"), new Date("16/08/1990"))
//        queryResult = Profile.findByUserAndDateOfBirthGreaterThan(userIns,new Date("16/08/1970"))
//        queryResult = Post.findByContentLikeOrDateCreatedLessThan("%post%", new Date("16/08/2018"))
//        queryResult = Post.findAllByContentLike("post%", [max: 3, offset: 2, sort: "content", order: "desc"])


        //************** CRITERIA **************

//        queryResult = postCriteria.list {
//            like("content", "post%")
//            maxResults(10)
//            order("content", "desc")
//        }

//        queryResult = postCriteria.list(offset:1,max:10) {
//            like("content", "post%")
//            order("content", "desc")
//        }
//        println(queryResult?.totalCount)


//        queryResult = postCriteria.list {
//            like("content", "post%")
//            maxResults(10)
//            order("content", "desc")
//        }

//         queryResult = postCriteria.list {
//             like("content", "post%")
//             user{
//                 eq('id',userIns?.id)
//
//                 profile{
//                     ge('salary',500D)
//                 }
//
//             }
//             maxResults(5)
//             order("content", "desc")
//         }
//
//         queryResult = postCriteria.list {
//             or{
//                 like("content", "%1%")
//                 like("content", "%2%")
//             }
//             user{
//                 eq('id',userIns?.id)
//             }
//             maxResults(5)
//         }

//        queryResult = postCriteria.list {
//            projections {
//                property('content')
//            }
//            maxResults(5)
//        }

//        queryResult = postCriteria.list {
//            projections {
//                count()
//            }
//        }

//        queryResult = postCriteria.list {
//            projections {
//                sum('id')
//            }
//        }

//        queryResult = postCriteria.list {
//            projections {
//                avg('id')
//            }
//        }

//        queryResult = postCriteria.list {
//            projections {
//                max('id')
//                min('id')
//            }
//        }


        //************** WHERE **************



//        queryResult = Post.where {
//            content == "post_content_10"
//        }.find()

//        queryResult = Profile.where {
//            (fullName != "ali full name" && bio == "bio") || (fullName == "ali full name" && user == userIns)
//        }.list(sort:"fullName")

//        queryResult = Profile.where {
//            salary in 1000D .. 1200D
//        }.list()

//        queryResult = Post.where {
//            content ==~ "post%" && user == userIns
//        }.list(max:5)

//        queryResult = Post.where {
//            user{
//                userId == "dana"
//            }
//        }.list(max:5)


//        queryResult = Profile.where {
//            def o1 = user
//            o1.userId == "ali" && bio == "bio"
//        }.list(sort:'o1.userId',max: 10)




       // END OF CLASS




//        queryResult = Profile.where {
//            salary > avg(salary)
//        }.list()


//        queryResult = Profile.where {
//            salary < sum(salary).of { bio == "bio" } &&
//        }.list()


//        queryResult = Profile.where {
//            year(dateOfBirth) == 1980
//        }.list()


        //************** HQL **************

//        queryResult = Post.findAll("from Post as p where p.content like 'post%'",[max: 5, offset: 1])
//        queryResult = Post.find("from Post as p where p.content like :value order by p.content",[value:'post%'])
//        queryResult = Post.executeUpdate("delete Post p where p.id = :recordId",[recordId:10L])
//        queryResult = Post.executeUpdate("update Post p set p.content = :value where id < 10",[value:"NEW CONTENT"])


        //************** SQL **************

//        queryResult = sql.rows("select * from profile ")


        //************** Dynamic Closuer **************
        List<Post> postList = []

        postList.findAll{
            Boolean result = it.content.contains("1")
            if(userIns){
                result = result && it.user == userIns
            }
            return result
        }


        println(queryResult)
        render "query done"

    }
}
