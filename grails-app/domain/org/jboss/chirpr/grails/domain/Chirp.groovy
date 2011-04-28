package org.jboss.chirpr.grails.domain

class Chirp {

    String text
    Date postedOn

    static belongsTo = [author:User];

    static constraints = {
    }
}
