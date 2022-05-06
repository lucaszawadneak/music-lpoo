/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;

/**
 *
 * @author Leo
 */
public class Link {
    private String linkSpotify;
    private String linkDeezer;
    private String linkAppleMusic;

    public Link(String linkSpotify, String linkDeezer, String linkAppleMusic) {
        this.linkSpotify = linkSpotify;
        this.linkDeezer = linkDeezer;
        this.linkAppleMusic = linkAppleMusic;
    }

    public String getLinkSpotify() {
        return linkSpotify;
    }

    public void setLinkSpotify(String linkSpotify) {
        this.linkSpotify = linkSpotify;
    }

    public String getLinkDeezer() {
        return linkDeezer;
    }

    public void setLinkDeezer(String linkDeezer) {
        this.linkDeezer = linkDeezer;
    }

    public String getLinkAppleMusic() {
        return linkAppleMusic;
    }

    public void setLinkAppleMusic(String linkAppleMusic) {
        this.linkAppleMusic = linkAppleMusic;
    }
    public Link(List<String> links, List<String> Types){
        if (Types.get(0).equals("Spotify") && Types.get(1).equals("AppleMusic")){
            this.linkSpotify = links.get(0); 
            this.linkAppleMusic = links.get(1);
        } else if (Types.get(0).equals("AppleMusic") && Types.get(1).equals("Deezer")){
            this.linkAppleMusic = links.get(0);
            this.linkDeezer = links.get(1);  
        } else if (Types.get(0).equals("Spotify") && Types.get(1).equals("Deezer")){
            this.linkSpotify = links.get(0); 
            this.linkDeezer = links.get(1); 
        }
    }
    public Link(String link, String Type) {
        switch(Type){
        case("Spotify"):
            this.linkSpotify = link;
            break;
        case("Deezer"):
            this.linkDeezer = link;
            break;
        case("Apple"):
            this.linkAppleMusic = link;
            break;
        }
    }
    
    public Link() {
    }
    
}
