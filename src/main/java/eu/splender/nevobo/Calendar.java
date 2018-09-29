package eu.splender.nevobo;

import org.json.JSONObject;

import com.github.kevinsawicki.http.HttpRequest;

public class Calendar {
    
    private JSONObject data;
    private String team; // 1230N2 2

    public static void main(String[] args) {
        Calendar cal = new Calendar();
        cal.getData(args[0]);
        if(cal.success()) {
            cal.getItems();
        }
    }

    private void getItems() {
        for(Object item : data.getJSONArray("data")) {
            if(item instanceof String) {                
                System.out.println(item);
            } else {
                JSONObject match = (JSONObject) item;
                if(playsInMatch(match)) {
                    
                }
                System.out.println(match.getString("id"));
            }
        }
    }

    private void getData(String team) {
        
        data = new JSONObject(HttpRequest.get("http://api.volleybal.nl/matches/team/" + team, true).body());
        
    }
    
    boolean success() {
        if("success".equals(data.getString("status"))) {
            return true;
        }
        System.err.println(data.getString("error"));
        return false;
    }
    
    boolean playsInMatch(JSONObject match) {
        if(team.equals(match.getJSONObject("home").getString("id"))) {
            return true;
        }
        if(team.equals(match.getJSONObject("away").getString("id"))) {
            return true;
        }
        return false;
    }
}
