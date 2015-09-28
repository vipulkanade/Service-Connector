package com.cfi.teamwarrior.webservices;

/**
 * Created by vipulkanade on 5/12/15.
 */
public interface WebserviceURL {

    String BASE_URL = "http://d0433077.ngrok.io/";

    String POST_JOB                 = BASE_URL + "postjob";
    String PERSON_LOGIN             = BASE_URL + "login";
    String GET_LIST_OF_JOB_SEEKER   = BASE_URL + "viewjob";

}
