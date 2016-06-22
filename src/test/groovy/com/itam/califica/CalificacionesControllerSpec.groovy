package com.itam.califica

import grails.test.mixin.*
import spock.lang.*

@TestFor(CalificacionesController)
@Mock(Calificaciones)
class CalificacionesControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.calificacionesList
            model.calificacionesCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.calificaciones!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def calificaciones = new Calificaciones()
            calificaciones.validate()
            controller.save(calificaciones)

        then:"The create view is rendered again with the correct model"
            model.calificaciones!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            calificaciones = new Calificaciones(params)

            controller.save(calificaciones)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/calificaciones/show/1'
            controller.flash.message != null
            Calificaciones.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def calificaciones = new Calificaciones(params)
            controller.show(calificaciones)

        then:"A model is populated containing the domain instance"
            model.calificaciones == calificaciones
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def calificaciones = new Calificaciones(params)
            controller.edit(calificaciones)

        then:"A model is populated containing the domain instance"
            model.calificaciones == calificaciones
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/calificaciones/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def calificaciones = new Calificaciones()
            calificaciones.validate()
            controller.update(calificaciones)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.calificaciones == calificaciones

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            calificaciones = new Calificaciones(params).save(flush: true)
            controller.update(calificaciones)

        then:"A redirect is issued to the show action"
            calificaciones != null
            response.redirectedUrl == "/calificaciones/show/$calificaciones.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/calificaciones/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def calificaciones = new Calificaciones(params).save(flush: true)

        then:"It exists"
            Calificaciones.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(calificaciones)

        then:"The instance is deleted"
            Calificaciones.count() == 0
            response.redirectedUrl == '/calificaciones/index'
            flash.message != null
    }
}
