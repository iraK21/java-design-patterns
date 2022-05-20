/**
 * Decorator is a structural design pattern that lets you attach new behaviors to objects
 * by placing these objects inside special wrapper objects that contain the behaviors. <br>
 * <p>
 * Components:
 * <ol>
 * <li>Component: Defines the interface for objects that can have responsibilities added to them dynamically</li>
 * <li>ConcreteComponent: Defines an object to which additional responsibilities can be attached</li>
 * <li>Decorator: Maintains reference to Component and defines interface which conforms to Component's interface</li>
 * <li>ConcreteDecorator: Adds responsibilities to the component</li>
 * </ol>
 * </p>
 */package org.example.structural.decorator;