import 'package:flutter/material.dart';

class Singleton {
  static final Singleton _singleton = Singleton._internal();

  factory Singleton() {
    return _singleton;
  }

  Singleton._internal();

  AppBar _appBar=AppBar();

  AppBar getAppBar()=>_appBar;

  AppBar setAppBar(AppBar appBar)=>_appBar=appBar;

}