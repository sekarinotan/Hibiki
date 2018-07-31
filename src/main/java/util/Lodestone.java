/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author adminpc
 */
public class Lodestone {

    private String characterName;
    private String lodestoneLink;
    private String avatarLink;
    private String glamourLink;
    
    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getLodestoneLink() {
        return lodestoneLink;
    }

    public void setLodestoneLink(String lodestoneLink) {
        this.lodestoneLink = lodestoneLink;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
    }

    public String getGlamourLink() {
        return glamourLink;
    }

    public void setGlamourLink(String glamourLink) {
        this.glamourLink = glamourLink;
    }
}
