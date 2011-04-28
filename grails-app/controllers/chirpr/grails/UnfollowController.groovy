package chirpr.grails

import grails.plugins.springsecurity.Secured
import org.jboss.chirpr.grails.domain.User

class UnfollowController {

    def springSecurityService

    static allowedMethods = [POST: "index"]

    @Secured('IS_AUTHENTICATED_FULLY')
    def index = {
        springSecurityService.currentUser.removeFromFollowed(User.findByUsername(params.id))
        User.withTransaction {
            status ->
            def previouslyFollowed = User.findByUsername(params.id)
            def me = springSecurityService.currentUser
            me.removeFromFollowed(previouslyFollowed)
            previouslyFollowed.removeFromFollowers(me)
            me.save()
            previouslyFollowed.save()

        }


        redirect(controller: 'profiles', action: 'index')
    }

}
