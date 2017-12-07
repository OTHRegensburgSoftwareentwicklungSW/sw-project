package com.ecorp.fritzshipping.entity;

import com.ecorp.fritzshipping.entity.util.RandomUUIDEntity;
import java.util.Collection;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Shipment extends RandomUUIDEntity{
    private int weight;
    private boolean pickup;
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="addressee",column=@Column(name="senderAddressee")),
        @AttributeOverride(name="street",column=@Column(name="senderStreet")),
        @AttributeOverride(name="houseNumber",column=@Column(name="senderHouseNumber")),
        @AttributeOverride(name="city",column=@Column(name="senderCity")),
        @AttributeOverride(name="postalCode",column=@Column(name="senderPostalCode")),
    })
    private Address sender;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="addressee",column=@Column(name="recipientAddressee")),
        @AttributeOverride(name="street",column=@Column(name="recipientStreet")),
        @AttributeOverride(name="houseNumber",column=@Column(name="recipientHouseNumber")),
        @AttributeOverride(name="city",column=@Column(name="recipientCity")),
        @AttributeOverride(name="postalCode",column=@Column(name="recipientPostalCode")),
    })
    private Address recipient;
    
    @OneToMany
    private Collection<TrackingPoint> trackingPoints;
    @OneToMany
    private Collection<TrackingNotification> trackingNotifications;
    
    public Shipment() {
        // Empty Default Constructor
    }

    public Shipment(int weight, boolean pickup, Address sender, Address recipient, Collection<TrackingPoint> trackingPoints, Collection<TrackingNotification> trackingNotifications) {
        this.weight = weight;
        this.pickup = pickup;
        this.sender = sender;
        this.recipient = recipient;
        this.trackingPoints = trackingPoints;
        this.trackingNotifications = trackingNotifications;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isPickup() {
        return pickup;
    }

    public void setPickup(boolean pickup) {
        this.pickup = pickup;
    }

    public Collection<TrackingPoint> getTrackingPoints() {
        return trackingPoints;
    }

    public void setTrackingPoints(Collection<TrackingPoint> trackingPoints) {
        this.trackingPoints = trackingPoints;
    }

    public Collection<TrackingNotification> getTrackingNotifications() {
        return trackingNotifications;
    }

    public void setTrackingNotifications(Collection<TrackingNotification> trackingNotifications) {
        this.trackingNotifications = trackingNotifications;
    }

    public Address getSender() {
        return sender;
    }

    public void setSender(Address sender) {
        this.sender = sender;
    }

    public Address getRecipient() {
        return recipient;
    }

    public void setRecipient(Address recipient) {
        this.recipient = recipient;
    }
}