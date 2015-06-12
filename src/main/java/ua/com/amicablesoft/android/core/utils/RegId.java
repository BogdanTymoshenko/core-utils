package ua.com.amicablesoft.android.core.utils;

/**
 * Created by bogdan on 6/12/15.
 */
public class RegId {
    private String regId;
    private String previouslyRegId;

    public String getRegId() {
        return regId;
    }

    /*package*/ void setRegId(String regId) {
        this.regId = regId;
    }

    public String getPreviouslyRegId() {
        return previouslyRegId;
    }

    /*package*/ void setPreviouslyRegId(String previouslyRegId) {
        this.previouslyRegId = previouslyRegId;
    }

    @Override
    public String toString() {
        return "RegId{" +
                "regId='" + regId + '\'' +
                ", previouslyRegId='" + previouslyRegId + '\'' +
                '}';
    }
}
