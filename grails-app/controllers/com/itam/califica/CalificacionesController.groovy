package com.itam.califica

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.converters.JSON

@Transactional(readOnly = true)
class CalificacionesController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def listar(){
        render Calificaciones.list() as JSON
    }
    
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Calificaciones.list(params), model:[calificacionesCount: Calificaciones.count()]
    }

    def show(Calificaciones calificaciones) {
        respond calificaciones
    }

    def create() {
        respond new Calificaciones(params)
    }

    @Transactional
    def save(Calificaciones calificaciones) {
        if (calificaciones == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (calificaciones.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond calificaciones.errors, view:'create'
            return
        }

        calificaciones.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'calificaciones.label', default: 'Calificaciones'), calificaciones.id])
                redirect calificaciones
            }
            '*' { respond calificaciones, [status: CREATED] }
        }
    }

    def edit(Calificaciones calificaciones) {
        respond calificaciones
    }

    @Transactional
    def update(Calificaciones calificaciones) {
        if (calificaciones == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (calificaciones.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond calificaciones.errors, view:'edit'
            return
        }

        calificaciones.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'calificaciones.label', default: 'Calificaciones'), calificaciones.id])
                redirect calificaciones
            }
            '*'{ respond calificaciones, [status: OK] }
        }
    }

    @Transactional
    def delete(Calificaciones calificaciones) {

        if (calificaciones == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        calificaciones.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'calificaciones.label', default: 'Calificaciones'), calificaciones.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'calificaciones.label', default: 'Calificaciones'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
