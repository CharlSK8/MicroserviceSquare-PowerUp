package com.pragma.powerup.usermicroservice.configuration;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final Long CLIENT_ROLE_ID = 1L;
    public static final Long EMPLOYEE_ROLE_ID = 2L;
    public static final Long PROVIDER_ROLE_ID = 3L;
    public static final int MAX_PAGE_SIZE = 2;
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String PERSON_CREATED_MESSAGE = "Person created successfully";
    public static final String USER_CREATED_MESSAGE = "User created successfully";
    public static final String RESTAURANT_CREATED_MESSAGE = "Restaurant created successfully";
    public static final String USER_DELETED_MESSAGE = "User deleted successfully";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String RESPONSE_WARNING_MESSAGE_KEY = "warning: ";
    public static final String WRONG_CREDENTIALS_MESSAGE = "Wrong credentials";
    public static final String NO_DATA_FOUND_MESSAGE = "No data found for the requested petition";
    public static final String PERSON_ALREADY_EXISTS_MESSAGE = "A person already exists with the DNI number provided";
    public static final String MAIL_ALREADY_EXISTS_MESSAGE = "A person with that mail already exists";
    public static final String PERSON_NOT_FOUND_MESSAGE = "Person not found in the database.";
    public static final String ROLE_NOT_FOUND_MESSAGE = "No role found with the id provided";
    public static final String ROLE_NOT_ALLOWED_MESSAGE = "No permission granted to create users with this role";
    public static final String USER_ALREADY_EXISTS_MESSAGE = "A user already exists with the role provided";
    public static final String USER_NOT_FOUND_MESSAGE = "No user found with the role provided";
    public static final String SWAGGER_TITLE_MESSAGE = "User API Pragma Power Up";
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "User microservice";
    public static final String SWAGGER_VERSION_MESSAGE = "1.0.0";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "http://springdoc.org";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";
    public static final String ENTERED_NULL_OR_EMPTY = "The entered field cannot be empty or null";
    public static final String PHONE_LENGTH = "The phone must be min 10 and max 13";
    public static final String PHONE_VALIDATION = "The field must contain numbers or the symbol '+'";
    public static final String ROLE_NOT_ALLOWED_MESSAGE_ADMIN = "No permission granted to create restaurants with this role";
    public static final String NIT_VALIDATION = "Only numbers are allowed";
    public static final String NAME_VALIDATION = "Numbers and letters are allowed, but numbers alone are not";
    public static final String PRICE_VALIDATION = "The value entered must be positive integer and greater than zero";
    public static final String RESTAURANT_NOT_FOUND_MESSAGE = "The id entered does not correspond to a restaurant in DB";
    public static final String DISH_CREATED_MESSAGE = "Dish created successfully";
    public static final String DISH_NOT_FOUND_MESSAGE = "The id entered does not correspond to a dish in DB";
    public static final String DISH_UPDATE_MESSAGE = "Successfully updated dish";
    public static final String ROLE_INVALID_MESSAGE = "Access denied, invalid role for this endpoint";
    public static final String DNI_ERROR = "The field must be numeric only";
}
