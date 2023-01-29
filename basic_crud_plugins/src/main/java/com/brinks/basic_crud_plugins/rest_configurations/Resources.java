package com.brinks.basic_crud_plugins.rest_configurations;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Resources {

    public static final String USERS = "/users";
    public static final String USER_ID = "id";
    public static final String USER_FINDID = "/{id}";

}
