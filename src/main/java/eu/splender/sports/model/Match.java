package eu.splender.sports.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Match {
	private static final SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
	private String MatchId;
	private String SeasonDescription;
	private int Round;
	private Date MatchDate;
	private Date MatchDateTime;
	private String StartTime;
	private String EndTime;
	private String FacilityId;
	private String HomeTeamName;
	private String AwayTeamName;
	private String FacilityLongitude;
	private String FacilityLatitude;
	private String FacilityPostalCode;
	private String FacilityStreetName;
	private String FacilityHouseNumber;
	private String FacilityCity;
	private String FacilityName;

	public String getMatchDescription() {
		return String.format("%s - %s", HomeTeamName, AwayTeamName);
	}

	public String getMatchId() {
		return MatchId;
	}

	public void setMatchId(String matchId) {
		MatchId = matchId;
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

	public String getAwayTeamName() {
		return AwayTeamName;
	}

	public void setAwayTeamName(String awayTeamName) {
		AwayTeamName = awayTeamName;
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

	public void setFacilityName(String name) {
		FacilityName = name;
	}

	public String getFacilityName() {
		return FacilityName;
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
		return dateformat.format(getMatchDateTime()).substring(0, 9) + getEndTime().replace(":", "");
	}
}
