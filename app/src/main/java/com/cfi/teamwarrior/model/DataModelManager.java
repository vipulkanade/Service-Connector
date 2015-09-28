package com.cfi.teamwarrior.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vipulkanade on 5/13/15.
 */
public class DataModelManager {

    private static DataModelManager mInstance;
    private static final Object obj = new Object();



   private List<JobList> mJobList = new ArrayList<JobList>();

    public DataModelManager() {
    }

    public static DataModelManager getInstance() {
        synchronized (obj) {
            if(mInstance == null)
                mInstance = new DataModelManager();
        }
        return mInstance;
    }

   public List<JobList> getJobList() {
        return mJobList;
    }

    public void setJobList(List<JobList> mJobList) {
        this.mJobList = mJobList;
    }
}
