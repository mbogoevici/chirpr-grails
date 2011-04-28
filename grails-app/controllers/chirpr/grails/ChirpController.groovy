package chirpr.grails

import grails.plugins.springsecurity.Secured
import org.jboss.chirpr.grails.domain.Chirp

class ChirpController {

    def springSecurityService

    def index = { }

    @Secured('IS_AUTHENTICATED_FULLY')
    def chirps = {

    }
}
