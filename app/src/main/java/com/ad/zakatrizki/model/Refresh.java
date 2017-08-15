package com.ad.zakatrizki.model;

/**
 * Created by Amay on 5/27/2017.
 */

public class Refresh {
    Boolean refresh=false;

    public Refresh(Boolean refresh) {
        this.refresh = refresh;
    }

    public Boolean getRefresh() {
        return refresh;
    }

    public void setRefresh(Boolean refresh) {
        this.refresh = refresh;
    }
}
