package main.com.smartdoc.model;

public class Insurance {
    private String provider;
    private String policyNumber;

    public Insurance(String provider, String policyNumber) {
        this.provider = provider;
        this.policyNumber = policyNumber;
    }

    public String getProvider() {
        return provider;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }
}