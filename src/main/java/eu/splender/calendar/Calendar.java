package eu.splender.calendar;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.VelocityContext;

import eu.splender.nevobo.Match;
import utils.Ftp;
import utils.VelocityUtil;

public class Calendar {
    private final static Logger LOGGER = Logger.getLogger(Calendar.class.getName());

    public void createICalFileForTeam(List<Match> matches, File icalFile, String teamname) {
        LOGGER.info("Creating calendar " + icalFile.getName());
        VelocityContext vc = new VelocityContext();
        vc.put("teamname", teamname);
        vc.put("matches", matches);
        String ical = VelocityUtil.templateMerge("/ical.vc", vc);
        // LOGGER.info(ical);
        try {
            // FileUtils.forceDelete(icalFile);
            FileUtils.writeStringToFile(icalFile, ical);
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());
        }
    }

    public void uploadCalendarFile(File icalFile, Map<String, String> credentials) {
        if (!credentials.get("ftpHost").isEmpty() && icalFile.exists()) {
            try {
                LOGGER.info("ftp upload van '" + icalFile.getAbsolutePath() + "' gestart");
                String remoteFilename = icalFile.getName().replaceAll(" ", "").toLowerCase();
                Ftp.upload(icalFile, remoteFilename, credentials.get("ftpHost"), credentials.get("ftpUploadPath"), credentials.get("ftpUsername"), credentials.get("ftpPassword"));
                LOGGER.info("ftp upload van '" + icalFile.getAbsolutePath() + "' geslaagd");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            LOGGER.info("ftp upload wordt overgeslagen");
        }
    }
}
