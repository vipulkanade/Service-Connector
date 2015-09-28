package com.cfi.teamwarrior.model;

import com.cfi.teamwarrior.constants.Constants;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by vipulkanade on 5/13/15.
 */
public class PostJob {

    private String sJobName;
    private String sJobSkill;
    private String sJobLanguage;

    public String getWage() {
        return sWage;
    }

    public void setWage(String sWage) {
        this.sWage = sWage;
    }

    private String sWage;

    public String getJobLanguage() {
        return sJobLanguage;
    }

    public void setJobLanguage(String sJobLanguage) {
        this.sJobLanguage = sJobLanguage;
    }



    public PostJob() {
    }

    public PostJob(JSONObject oJSONObject) {
        sJobName = oJSONObject.optString(Constants.PERSON_NAME);
        sJobSkill = oJSONObject.optString(Constants.JOB_SKILL);
        sJobLanguage = oJSONObject.optString(Constants.JOB_LANGUAGE);
    }

    public String getEmployeeName() {
        return sJobName;
    }

    public void setEmployeeName(String sJobName) {
        this.sJobName = sJobName;
    }

    public String getEmployeeID() {
        return sJobSkill;
    }

    public void setEmployeeID(String sJobSkill) {
        this.sJobSkill = sJobSkill;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject oJSON = new JSONObject();
        oJSON.put(Constants.PERSON_NAME, sJobName);
        oJSON.put(Constants.JOB_SKILL, sJobSkill);
        oJSON.put(Constants.JOB_LANGUAGE, sJobLanguage);
        oJSON.put(Constants.WAGE, sWage);
        return oJSON;
    }
}
