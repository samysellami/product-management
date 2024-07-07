package com.axa.productmanagement.models;

import jakarta.persistence.Embeddable;

@Embeddable
record Name(String firstName, String lastName) {}