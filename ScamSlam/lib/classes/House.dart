import 'package:flutter/material.dart';
import "dart:core";

class House
{
  String _name="";
  String _address="";
  double _price=0.0;
  List<Image> _images=[];

  House(String name,String address,double price)
  {
    _name=name;
    _address=address;
    _price=price;
  }

  String getName()=>_name;

  String getAddress()=>_address;

  double getPrice()=>_price;

  List<Image> getImages()=>_images;

  void setName(String name)=>_name=name;

  void setAddress(String address)=>_address=address;

  void setPrice(double price)=>_price=price;

  void addImage(Image image)=>_images.add(image);

  void removeImage(int index)=>_images.removeAt(index);
}