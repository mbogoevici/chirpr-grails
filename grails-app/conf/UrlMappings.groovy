class UrlMappings {


    static mappings = {

    "/follow/$id?"(resource: "follow") {
        action = [POST:"index"]
    }

    "/unfollow/$id?"(resource: "unfollow") {
        action = [POST:"index"]
    }


    "/login/auth" {
        controller = 'openId'
        action = 'auth'
    }
    "/login/openIdCreateAccount" {
        controller = 'openId'
        action = 'createAccount'
    }
        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/index")
        "500"(view: '/error')
    }
}
