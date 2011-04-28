package chirpr.grails

import org.jboss.chirpr.grails.domain.User
import grails.plugins.springsecurity.SpringSecurityService

class ProfilesController {

    def springSecurityService

    def index = {
        if (springSecurityService.currentUser != null) {

           def userList = User.findAll().collect { new ProfileWrapper(user: it, followedByMe: (springSecurityService.currentUser.follows(it.username)))}
            render view: 'index', model: [users: userList]
        }
        else
        {
            def userList = User.findAll().collect { new ProfileWrapper(user: it, followedByMe: false)}
            render view: 'index', model: [users: userList]
        }

    }

}


class ProfileWrapper {
    User user
    boolean followedByMe
}