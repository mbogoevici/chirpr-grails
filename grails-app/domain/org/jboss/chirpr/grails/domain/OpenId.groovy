package org.jboss.chirpr.grails.domain

class OpenId {

	String url

	static belongsTo = [user: User]

	static constraints = {
		url unique: true
	}
}
