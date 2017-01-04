package com.git.onedayrex.entity;
import java.util.List;
public class Songs {
private int id;

private String name;

private List<Artists> artists ;

private Album album;

private int duration;

private int copyrightId;

private int status;

private List<String> alias ;

private int rtype;

private int ftype;

private int mvid;

private int fee;

private String rUrl;

public void setId(int id){
this.id = id;
}
public int getId(){
return this.id;
}
public void setName(String name){
this.name = name;
}
public String getName(){
return this.name;
}
public void setArtists(List<Artists> artists){
this.artists = artists;
}
public List<Artists> getArtists(){
return this.artists;
}
public void setAlbum(Album album){
this.album = album;
}
public Album getAlbum(){
return this.album;
}
public void setDuration(int duration){
this.duration = duration;
}
public int getDuration(){
return this.duration;
}
public void setCopyrightId(int copyrightId){
this.copyrightId = copyrightId;
}
public int getCopyrightId(){
return this.copyrightId;
}
public void setStatus(int status){
this.status = status;
}
public int getStatus(){
return this.status;
}
public void setString(List<String> alias){
this.alias = alias;
}
public List<String> getString(){
return this.alias;
}
public void setRtype(int rtype){
this.rtype = rtype;
}
public int getRtype(){
return this.rtype;
}
public void setFtype(int ftype){
this.ftype = ftype;
}
public int getFtype(){
return this.ftype;
}
public void setMvid(int mvid){
this.mvid = mvid;
}
public int getMvid(){
return this.mvid;
}
public void setFee(int fee){
this.fee = fee;
}
public int getFee(){
return this.fee;
}
public void setRUrl(String rUrl){
this.rUrl = rUrl;
}
public String getRUrl(){
return this.rUrl;
}

}
