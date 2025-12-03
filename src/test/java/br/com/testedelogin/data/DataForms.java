package br.com.testedelogin.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Data Transfer Object (DTO) that represents the form data
 * used for registration or user information submission.
 * <p>
 * This class is immutable and uses Lombok annotations to
 * automatically generate getters and a full constructor.
 * </p>
 */
@Getter
@AllArgsConstructor
public class DataForms {

    private String firstName;

    private String lastName;

    private String company;

    private String address1;

    private String address2;

    private String city;

    private String postCode;

    private String country;

    private String regionState;
}