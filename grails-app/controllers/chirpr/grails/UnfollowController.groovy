package chirpr.grails

import grails.plugins.springsecurity.Secured
import org.jboss.chirpr.grails.domain.User

class UnfollowController {

    def  springSecurityService

    static allowedMethods = [POST:"index"]

    @Secured('IS_AUTHENTICATED_FULLY')
    def index = {
       springSecurityService.currentUser.removeFromFollowed(User.findByUsername(params.id))
       User.withTransaction {
           status->
            User u = springSecurityService.currentUser
            u.save()
       }

       redirect(controller:'profiles',action:'index')
    }

}
