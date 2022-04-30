import 'package:flutter/material.dart';
import "dart:core";

class House
{
  String _title="";
  String _owner="";
  double _price=0.0;
  List<String> _images=[];

  House(String title,String owner,double price)
  {
    _title=title;
    _owner=owner;
    _price=price;
  }

  String getOwner()=>_owner;

  String getTitle()=>_title;

  double getPrice()=>_price;

  List<String> getImages()=>_images;

  void setOwner(String owner)=>_owner=owner;

  void setTitle(String title)=>_title=title;

  void setPrice(double price)=>_price=price;

  void addImage(String imageUrl)=>_images.add(imageUrl);

  void removeImage(int index)=>_images.removeAt(index);
}