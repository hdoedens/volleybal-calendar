package eu.splender.nevobo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Match {
    private static final SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
    private String InternalMatchId;
    private String PublicMatchId;
    private String ExternalMatchId;
    private String SeasonDescription;
    private int Round;
    private Date MatchDate;
    private Date MatchDateTime;
    private String MatchDescription;
    private String StartTime;
    private String EndTime;
    private String FacilityId;
    private String HomeTeamName;
    private String HomeTeamClub;
    private String AwayTeamName;
    private String AwayTeamClub;
    private String FacilityLongitude;
    private String FacilityLatitude;
    private String FacilityPostalCode;
    private String FacilityStreetName;
    private String FacilityHouseNumber;
    private String FacilityCity;

    public String getMatchDescription() {
        return MatchDescription;
    }

    public void setMatchDescription(String matchDescription) {
        MatchDescription = matchDescription;
    }

    public String getInternalMatchId() {
        return InternalMatchId;
    }

    public void setInternalMatchId(String internalMatchId) {
        InternalMatchId = internalMatchId;
    }

    public String getPublicMatchId() {
        return PublicMatchId;
    }

    public void setPublicMatchId(String publicMatchId) {
        PublicMatchId = publicMatchId;
    }

    public String getExternalMatchId() {
        return ExternalMatchId;
    }

    public void setExternalMatchId(String externalMatchId) {
        ExternalMatchId = externalMatchId;
    }

    public String getSeasonDescription() {
        return SeasonDescription;
    }

    public void setSeasonDescription(String seasonDescription) {
        SeasonDescription = seasonDescription;
    }

    public int getRound() {
        return Round;
    }

    public void setRound(int round) {
        Round = round;
    }

    public Date getMatchDate() {
        return MatchDate;
    }

    public void setMatchDate(Date matchDate) {
        MatchDate = matchDate;
    }

    public Date getMatchDateTime() {
        return MatchDateTime;
    }

    public void setMatchDateTime(Date matchDateTime) {
        MatchDateTime = matchDateTime;
    }

    public String getFacilityId() {
        return FacilityId;
    }

    public void setFacilityId(String facilityId) {
        FacilityId = facilityId;
    }

    public String getHomeTeamName() {
        return HomeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        HomeTeamName = homeTeamName;
    }

    public String getHomeTeamClub() {
        return HomeTeamClub;
    }

    public void setHomeTeamClub(String homeTeamClub) {
        HomeTeamClub = homeTeamClub;
    }

    public String getAwayTeamName() {
        return AwayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        AwayTeamName = awayTeamName;
    }

    public String getAwayTeamClub() {
        return AwayTeamClub;
    }

    public void setAwayTeamClub(String awayTeamClub) {
        AwayTeamClub = awayTeamClub;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getFacilityLongitude() {
        return FacilityLongitude;
    }

    public void setFacilityLongitude(String facilityLongitude) {
        FacilityLongitude = facilityLongitude;
    }

    public String getFacilityLatitude() {
        return FacilityLatitude;
    }

    public void setFacilityLatitude(String facilityLatitude) {
        FacilityLatitude = facilityLatitude;
    }

    public String getFacilityPostalCode() {
        return FacilityPostalCode;
    }

    public void setFacilityPostalCode(String facilityPostalCode) {
        FacilityPostalCode = facilityPostalCode;
    }

    public String getFacilityStreetName() {
        return FacilityStreetName;
    }

    public void setFacilityStreetName(String facilityStreetName) {
        FacilityStreetName = facilityStreetName;
    }

    public String getFacilityHouseNumber() {
        return FacilityHouseNumber;
    }

    public void setFacilityHouseNumber(String facilityHouseNumber) {
        FacilityHouseNumber = facilityHouseNumber;
    }

    public String getFacilityCity() {
        return FacilityCity;
    }

    public void setFacilityCity(String facilityCity) {
        FacilityCity = facilityCity;
    }

    public String getLocationBasedOnFacility() {
        return "GEO:" + getFacilityLatitude() + ";" + getFacilityLongitude();
    }

    public String getDTStart() {
        return dateformat.format(getMatchDateTime());
    }

    public String getDTEnd() {
        return dateformat.format(getMatchDateTime()).substring(0,9) + getEndTime().replace(":", "");
    }
}
