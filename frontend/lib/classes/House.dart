

import 'package:flutter/material.dart';
import "dart:core";

class House
{
  String _title="";
  String _owner="";
  double _price=0.0;
  String _priceCurrency="";
  int _id=0;
  int _upvotes=0;
  int _downvotes=0;
  String _scamCertainty="";
  List<String> _images=[];

  House(int id, String title,String owner,double price, int upvotes, int downvotes, String scamCertainty, String priceCurrency)
  {
    _id=id;
    _title=title;
    _owner=owner;
    _price=price;
    _upvotes=upvotes;
    _downvotes=downvotes;
    _scamCertainty=scamCertainty;
    _priceCurrency=priceCurrency;
  }

  int getId()=>_id;

  String getOwner()=>_owner;

  String getTitle()=>_title;

  double getPrice()=>_price;

  int getUpvotes()=>_upvotes;

  int getDownvotes()=>_downvotes;

  String getScamCertainty()=>_scamCertainty;

  String getPriceCurrency()=>_priceCurrency;

  List<String> getImages()=>_images;

  void setId(int id)=>_id=id;

  void setOwner(String owner)=>_owner=owner;

  void setTitle(String title)=>_title=title;

  void setPrice(double price)=>_price=price;

  void setUpvotes(int upvotes)=>_upvotes=upvotes;

  void setDownvotes(int downvotes)=>_downvotes=downvotes;

  void setScamCertainty(String scamCertainty)=>_scamCertainty=scamCertainty;

  void setPriceCurrency(String priceCurrency)=>_priceCurrency=priceCurrency;

  void addImage(String imageUrl)=>_images.add(imageUrl);

  void removeImage(int index)=>_images.removeAt(index);

 /* static House fromJson(json) {
    House house = new House();
    house._id = json['id'];
    house.addImage(json['fileURL']);
    house._owner = json['owner'];
    house._price = json['priceAmount'];
    house._priceCurrency = json['priceCurrency'];
    house._title = json['title'];
    house._upvotes = json['upvotes'];
    house._downvotes = json['downvotes'];
    house._scamCertainty = json['scamCertainty'];
    return house;
  }*/

  static House fromJson(json){
    var id = json['id'];
    var title = json['title'];
    var owner = json['owner'];
    var price = json['priceAmount'];
    var priceCurrency = json['priceCurrency'];
    var upvotes = json['upvotes'];
    var downvotes = json['downvotes'];
    var scamCertainty = json['scamCertainty'];

    House house = new House(id, title, owner, price, upvotes, downvotes, scamCertainty, priceCurrency);
    house.addImage(json['fileURL']);
    return house;
  }

  static House fromMap(Map<String, dynamic> json)
  {
    var id = json['id'];
    var title = json['title'];
    var owner = json['owner'];
    var price = json['priceAmount'];
    var priceCurrency = json['priceCurrency'];
    var upvotes = json['upvotes'];
    var downvotes = json['downvotes'];
    var scamCertainty = json['scamCertainty'];

    House house = new House(id, title, owner, price, upvotes, downvotes, scamCertainty, priceCurrency);
    house.addImage(json['fileURL']);
    return house;
  }

  //static House fromString(String jstring)=>JsonCodec().d;
}
