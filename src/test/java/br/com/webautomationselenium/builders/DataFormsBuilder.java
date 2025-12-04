package br.com.webautomationselenium.builders;

import br.com.webautomationselenium.builders.DataFormsBuilder;
import br.com.webautomationselenium.data.DataForms;

/**
 * Builder class responsible for creating {@link DataForms} objects
 * using the Builder Pattern.
 * <p>
 * This class provides default values and fluent methods
 * to customize form data before building the final object.
 * </p>
 */
public class DataFormsBuilder {

    private String firstName = "Teste";
    private String lastName = "Automatizado";
    private String company = "Empresa Teste";
    private String address1 = "Rua Teste, 123";
    private String address2 = "Bairro Teste";
    private String city = "Cidade Teste";
    private String postCode = "12345-678";
    private String country = "Brazil";
    private String regionState = "São Paulo";

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCountry() {
        return country;
    }

    public String getRegionState() {
        return regionState;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the first name to be used
     * @return the current builder instance
     */
    public DataFormsBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the last name to be used
     * @return the current builder instance
     */
    public DataFormsBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Sets the company name.
     *
     * @param company the company name
     * @return the current builder instance
     */
    public DataFormsBuilder withCompany(String company) {
        this.company = company;
        return this;
    }

    /**
     * Sets the primary address.
     *
     * @param address1 the main address
     * @return the current builder instance
     */
    public DataFormsBuilder withAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    /**
     * Sets the secondary address.
     *
     * @param address2 the secondary address
     * @return the current builder instance
     */
    public DataFormsBuilder withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    /**
     * Sets the city.
     *
     * @param city the city name
     * @return the current builder instance
     */
    public DataFormsBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * Sets the postal code.
     *
     * @param postCode the postal code
     * @return the current builder instance
     */
    public DataFormsBuilder withPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    /**
     * Sets the country.
     *
     * @param country the country name
     * @return the current builder instance
     */
    public DataFormsBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * Sets the state or region.
     *
     * @param regionState the state or region name
     * @return the current builder instance
     */
    public DataFormsBuilder withRegionState(String regionState) {
        this.regionState = regionState;
        return this;
    }

    /**
     * Builds and returns a {@link DataForms} object using the current data.
     *
     * @return a fully populated {@link DataForms} instance
     */
    public DataForms build() {
        return new DataForms(
            firstName,
            lastName,
            company,
            address1,
            address2,
            city,
            postCode,
            country,
            regionState
        );
    }
}