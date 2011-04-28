package chirpr.grails

import grails.plugins.springsecurity.Secured
import org.jboss.chirpr.grails.domain.User

class FollowController {

    def  springSecurityService

    static allowedMethods = [POST:"index"]

    @Secured('IS_AUTHENTICATED_FULLY')
    def index = {

        User.withTransaction {
            status ->
            def newlyFollowed = User.findByUsername(params.id)
            def me = springSecurityService.currentUser
            springSecurityService.currentUser.addToFollowed(newlyFollowed)
            newlyFollowed.addToFollowers(me)
            me.save()
            newlyFollowed.save()
        }

       redirect(controller:'profiles',action:'index')
    }

}
