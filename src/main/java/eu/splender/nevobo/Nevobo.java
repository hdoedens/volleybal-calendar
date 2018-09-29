package eu.splender.nevobo;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.github.kevinsawicki.http.HttpRequest;

import eu.splender.calendar.Calendar;
import eu.splender.sports.model.Match;
import eu.splender.utils.NevoboDateUtils;

public class Nevobo {

	private JSONObject data;
	private String team; // 1230N2 2

	public static void main(String[] args) throws JSONException, ParseException {
		Nevobo nevobo = new Nevobo();
		nevobo.setTeam(args[0]);
		nevobo.getData();
		if (nevobo.success()) {

		}
		Calendar.createICalFileForTeam(nevobo.getMatches(), new File("C:\\temp\\", nevobo.getTeam() + ".ical"),
				nevobo.getTeam());
	}

	private void setTeam(String team) {
		this.team = team;
	}

	public String getTeam() {
		return team;
	}

	private List<Match> getMatches() throws JSONException, ParseException {
		List<Match> matches = new ArrayList<Match>();
		for (Object item : data.getJSONArray("data")) {
			if (item instanceof String) {
				System.out.println(item);
			} else {
				JSONObject match = (JSONObject) item;
				if (playsInMatch(match)) {
					// get match details
					Match m = new Match();
					m.setAwayTeamName(match.getJSONObject("away").getString("name"));
					m.setHomeTeamName(match.getJSONObject("home").getString("name"));
					m.setMatchId(match.getString("id"));
					m.setMatchDateTime(
							NevoboDateUtils.getDateTime(match.getString("description"), match.getString("time")));
					m.setFacilityName(match.getString("location"));

					// add match to matchlist
					matches.add(m);
				}
			}
		}
		return matches;
	}

	private void getData() {

		data = new JSONObject(HttpRequest.get("http://api.volleybal.nl/matches/team/" + team, true).body());

	}

	boolean success() {
		if ("success".equals(data.getString("status"))) {
			return true;
		}
		System.err.println(data.getString("error"));
		return false;
	}

	boolean playsInMatch(JSONObject match) {
		if (team.equals(match.getJSONObject("home").getString("id"))) {
			return true;
		}
		if (team.equals(match.getJSONObject("away").getString("id"))) {
			return true;
		}
		return false;
	}
}
