package com.priyanka.ifst;

public class EventLists {
    private String session;
    private String venue;
    private String time;
    private  String coordinator;
    private String coordinator2;

    public EventLists() {
        //default needed
    }

    public EventLists(String session, String venue, String time, String coordinator, String coordinator2) {
        this.session = session;
        this.venue = venue;
        this.time = time;
        this.coordinator = coordinator;
        this.coordinator2 = coordinator2;
    }

    public String getSession() {
        return session;
    }

    public String getVenue() {
        return venue;
    }

    public String getTime() {
        return time;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public String getCoordinator2() {
        return coordinator2;
    }
}
