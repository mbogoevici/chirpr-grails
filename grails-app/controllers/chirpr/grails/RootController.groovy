package chirpr.grails

import org.jboss.chirpr.grails.domain.Chirp
import org.jboss.chirpr.grails.domain.User

class RootController {

    def index = {
        def all = params.author == null? Chirp.findAll() : Chirp.findAllByAuthor(User.findByUsername(params.author))
        render view:'index', model:[chirps:all];
    }
}
