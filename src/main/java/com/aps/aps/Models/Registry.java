package com.aps.aps.Models;

import javax.persistence.Embedded;
import java.util.*;

public class Registry {

    private static Registry single_instance = null;
    public static final String[] getUser_url = null;
    private String name;
    private String config_url;
    @Embedded
    private List<Campo> json_params_url;
    private String user_url;
    private String analytic_url;
    @Embedded
    private List<Analytica> qualAnalytics;
    
    public Registry() {
    }

    public Registry(String name, String config_url, List<Campo> json_params_url, String user_url, String analytic_url,
            List<Analytica> qualAnalytics) {
        this.name = name;
        this.config_url = config_url;
        this.json_params_url = json_params_url;
        this.user_url = user_url;
        this.analytic_url = analytic_url;
        this.qualAnalytics = qualAnalytics;
    }

    public static Registry getSingle_instance() {
        return single_instance;
    }

    public static void setSingle_instance(Registry single_instance) {
        Registry.single_instance = single_instance;
    }

    public static String[] getGetuserUrl() {
        return getUser_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfig_url() {
        return config_url;
    }

    public void setConfig_url(String config_url) {
        this.config_url = config_url;
    }

    public List<Campo> getJson_params_url() {
        return json_params_url;
    }

    public void setJson_params_url(List<Campo> json_params_url) {
        this.json_params_url = json_params_url;
    }

    public String getUser_url() {
        return user_url;
    }

    public void setUser_url(String user_url) {
        this.user_url = user_url;
    }

    public String getAnalytic_url() {
        return analytic_url;
    }

    public void setAnalytic_url(String analytic_url) {
        this.analytic_url = analytic_url;
    }

    public List<Analytica> getQualAnalytics() {
        return qualAnalytics;
    }

    public void setQualAnalytics(List<Analytica> qualAnalytics) {
        this.qualAnalytics = qualAnalytics;
    }
    
}
