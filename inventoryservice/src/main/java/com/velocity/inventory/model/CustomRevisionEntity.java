package com.velocity.inventory.model;

	import org.hibernate.envers.DefaultRevisionEntity;
	import org.hibernate.envers.RevisionEntity;
	import org.hibernate.envers.RevisionNumber;
	import org.hibernate.envers.RevisionTimestamp;

	import javax.persistence.Entity;
	import javax.persistence.Table;

	@Entity
	@RevisionEntity
	@Table(name = "revinfo")
	public class CustomRevisionEntity extends DefaultRevisionEntity {

	    // Add custom fields if needed

	    // Example:
	    // private String username;

	    // Getters and setters for custom fields
	}
