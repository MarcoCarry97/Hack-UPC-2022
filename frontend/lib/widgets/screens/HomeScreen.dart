
import 'package:flutter/material.dart';
import 'package:scamslam/widgets/components/HouseGrid.dart';
import 'package:scamslam/widgets/components/searchbar.dart';
import 'package:http/http.dart' as http;

import '../../classes/House.dart';
import '../../tools/Singleton.dart';

import 'dart:async';
import 'dart:convert';
import "dart:core";

class HomeScreen extends StatefulWidget
{
  const HomeScreen({Key? key}) : super(key: key);

  @override
  State<StatefulWidget> createState() {
    return HomeScreenState();
  }

}

class HomeScreenState extends State<HomeScreen>
{
  String BACKEND_URL = "https://3a8b-147-83-201-134.eu.ngrok.io/";

  @override
  Widget build(BuildContext context)
  {
    List<House> list;
    final response = await http.get(BACKEND_URL + "listings");
    list = (json.decode(response.body) as List)
        .map((i) => House.fromJson(i))
        .toList();

    Singleton single=Singleton();
    //single.setAppBar(makeAppBar());
    return Scaffold(appBar: single.getAppBar(),
      floatingActionButton: FloatingActionButton(
        onPressed: ()=>{},
        backgroundColor: Colors.red,
        child: Icon(Icons.add,color: Colors.white,),
      ),
      body: Column(
        children: [
          SearchBar(),
          HouseGrid(list)
        ],
      ),
    );
  }
}
