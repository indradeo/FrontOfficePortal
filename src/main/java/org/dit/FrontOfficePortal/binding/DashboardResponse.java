package org.dit.FrontOfficePortal.binding;

public class DashboardResponse {

    private long totalEnquiries;
    private long enrolledEnquiries;
    private long lostEnquiries;

    public long getEnrolledEnquiries() {
        return enrolledEnquiries;
    }

    public void setEnrolledEnquiries(long enrolledEnquiries) {
        this.enrolledEnquiries = enrolledEnquiries;
    }

    public long getLostEnquiries() {
        return lostEnquiries;
    }

    public void setLostEnquiries(long lostEnquiries) {
        this.lostEnquiries = lostEnquiries;
    }

    public long getTotalEnquiries() {
        return totalEnquiries;
    }

    public void setTotalEnquiries(long totalEnquiries) {
        this.totalEnquiries = totalEnquiries;
    }
}
