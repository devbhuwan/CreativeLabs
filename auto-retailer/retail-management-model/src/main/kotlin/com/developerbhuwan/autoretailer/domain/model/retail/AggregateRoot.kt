package com.developerbhuwan.autoretailer.domain.model.retail

import org.springframework.data.domain.AfterDomainEventPublication
import org.springframework.data.domain.DomainEvents
import java.util.*

abstract class AggregateRoot<EventType> {

    @Transient
    private val domainEvents = ArrayList<EventType>()

    /**
     * All domain events currently captured by the aggregate.
     */
    @DomainEvents
    fun domainEvents(): Collection<EventType> {
        return Collections.unmodifiableList<EventType>(domainEvents)
    }

    /**
     * Registers the given event object for publication on a call to a Spring Data repository's save methods.
     */
    protected fun registerEvent(event: EventType): EventType {
        this.domainEvents.add(event)
        return event
    }

    /**
     * Clears all domain events currently held. Usually invoked by the infrastructure in place in Spring Data
     * repositories.
     */
    @AfterDomainEventPublication
    protected fun clearDomainEvents() {
        this.domainEvents.clear()
    }

}