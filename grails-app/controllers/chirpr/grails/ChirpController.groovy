package chirpr.grails

import grails.plugins.springsecurity.Secured
import org.jboss.chirpr.grails.domain.Chirp

class ChirpController {

    def springSecurityService

    @Secured('IS_AUTHENTICATED_FULLY')
    def index = {

        def chirp = new Chirp(author: springSecurityService.currentUser, postedOn: new Date(), text: params.text)
        Chirp.withTransaction {
            chirp.save()
        }
        redirect(controller: 'root', action: 'index')


    }

}
