/**
 * Bridge enables decoupling an abstraction from its implementation so that the two can vary independently.
 * <p>
 * Components:
 * <ol>
 * <li>Abstraction: Defines the abstraction interface and maintains reference to Implementor</li>
 * <li>RefinedAbstraction: Extends the Abstraction interface</li>
 * <li>Implementor: Defines the interface for implementation classes</li>
 * <li>ConcreteImplementor: Defines concrete implementation for Implementor</li>
 * </ol>
 * </p>
 */
package org.example.structural.bridge;