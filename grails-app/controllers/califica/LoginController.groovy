package califica

import grails.converters.JSON

class LoginController {

    def index() { }

    def auth(){
        def user =  request.JSON.username
        def pass = request.JSON.password
        def res = [:]
        
        System.out.println(user) 
	if(user == 'dmeza'){
	    res.lastname = "Meza"
            res.name = "Gerardo"
            res.roles = [:]
            res.roles = ["PROFESOR", "JEFE DEPTO"] 
            res.email = user
            res.secondlastname = "Gonzalez"
	}else{
 	    res.error="No coincide el usuario"
            res.code=101
	}

        render res as JSON
    }
}
