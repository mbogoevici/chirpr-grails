package chirpr.grails

import grails.plugins.springsecurity.Secured

class ChirpController {

    def springSecurityService

    def index = { }

    @Secured('IS_AUTHENTICATED_FULLY')
    def chirps = {
        return
    }
}
