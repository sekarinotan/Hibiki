/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adminpc
 */
public class Configuration {

    private String botToken;
    private String ffLogsToken;
    private String googleToken;

    public String getGoogleToken() {
        return googleToken;
    }

    public void setGoogleToken(String googleToken) {
        this.googleToken = googleToken;
    }

    public String getBotToken() {
        return botToken;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    public String getFfLogsToken() {
        return ffLogsToken;
    }

    public void setFfLogsToken(String ffLogsToken) {
        this.ffLogsToken = ffLogsToken;
    }
}
