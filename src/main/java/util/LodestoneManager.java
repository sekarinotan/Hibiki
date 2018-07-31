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
public class LodestoneManager {

    private static LodestoneManager instance;
    private Lodestone lodestone;
    private String lodestoneLink;
    private String[] args;

    public static LodestoneManager getInstance(String[] args) throws IOException {
//        if (instance == null) {
//            instance = new LodestoneManager(args);
//        }
        return new LodestoneManager(args);
    }

    public LodestoneManager(String[] args) throws IOException {
        this.lodestone = new Lodestone();
        this.args = args;
        getData();
    }

    public void characterLink() throws IOException {
        args[1] = args[1].substring(0, 1).toUpperCase() + args[1].substring(1);
        String url = "https://na.finalfantasyxiv.com/lodestone/character/?q=" + args[2] + "+" + args[3] + "&worldname=" + args[1] + "";
        Document document = Jsoup.connect(url).get();
        Element body = document.body();
        Elements characterLink = body.getElementsByClass("entry__link");
        for (int i = 0; i < characterLink.size(); i++) {
            String name = characterLink.get(i).getElementsByTag("img").attr("alt");
            if (name.equalsIgnoreCase(args[2] + " " + args[3])) {
                this.lodestoneLink = characterLink.get(i).getElementsByTag("a").attr("href");
            }
        }
    }

    public String getAvatar(String outerHTML) {
        Document doc = Jsoup.parseBodyFragment(outerHTML);
        return doc.body().getElementsByTag("img").attr("src");
    }

    public String getGlamour(String outerHTML) {
        Document doc = Jsoup.parseBodyFragment(outerHTML);
        return doc.body().getElementsByTag("a").attr("href");
    }

    public void getData() throws IOException {
        characterLink();
        String url = "https://na.finalfantasyxiv.com" + lodestoneLink;
        Document document = Jsoup.connect(url).get();
        Element body = document.body();
        this.lodestone.setAvatarLink(getAvatar(body.getElementsByClass("frame__chara__face").outerHtml()));
        this.lodestone.setCharacterName(body.getElementsByClass("frame__chara__name").text());
        this.lodestone.setGlamourLink(getGlamour(body.getElementsByClass("character__detail__image").outerHtml()));
        this.lodestone.setLodestoneLink(url);
    }
    
    public Lodestone getLodestone() {
        return this.lodestone;
    }
}
