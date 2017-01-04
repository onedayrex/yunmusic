package com.git.onedayrex.entity;
import java.util.List;
public class Album {
private int id;

private String name;

private Artist artist;

private int publishTime;

private int size;

private int copyrightId;

private int status;

private List<String> alias ;

private int picId;

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
public void setArtist(Artist artist){
this.artist = artist;
}
public Artist getArtist(){
return this.artist;
}
public void setPublishTime(int publishTime){
this.publishTime = publishTime;
}
public int getPublishTime(){
return this.publishTime;
}
public void setSize(int size){
this.size = size;
}
public int getSize(){
return this.size;
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
public void setPicId(int picId){
this.picId = picId;
}
public int getPicId(){
return this.picId;
}

}
