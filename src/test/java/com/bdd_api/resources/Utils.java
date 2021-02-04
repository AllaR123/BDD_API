package com.bdd_api.resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {

    public static RequestSpecification req;

    public RequestSpecification requestSpecification() throws IOException {

        if(req==null) {

            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));        // we have to pass path of the file
            req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))        // we log all the requests
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;
    }


    public static String getGlobalValue(String key) throws IOException {       // key is our baseUrl

        Properties prop = new Properties();     //Properties class for reading our global file and path to it
        FileInputStream fis =  new FileInputStream("/Users/allarudenko/IdeaProjects/BDD_API_Udemy/src/test/java/com/bdd_api/resources/global.properties");
        prop.load(fis);
        return prop.getProperty(key);        // from global.properties

    }


}