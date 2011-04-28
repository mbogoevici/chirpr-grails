package chirpr.grails

import grails.plugins.springsecurity.Secured
import org.jboss.chirpr.grails.domain.User
import org.jboss.chirpr.grails.domain.Chirp

class FriendsController {

    def springSecurityService

    @Secured('IS_AUTHENTICATED_FULLY')
    def index = {
        User me = springSecurityService.currentUser
        def followedChirps = Chirp.findAllByAuthorInList (me.followed)
        render (view: 'index', model: [chirps:followedChirps])
    }
}
