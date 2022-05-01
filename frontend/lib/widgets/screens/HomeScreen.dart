

import 'dart:js';

import 'package:flutter/material.dart';
import 'package:scamslam/widgets/components/HouseGrid.dart';
import 'package:scamslam/widgets/components/searchbar.dart';
import "package:http/http.dart" as http;

import '../../classes/House.dart';
import '../../tools/Singleton.dart';

import 'dart:async';
import 'dart:convert' as convert;
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

  List<House> _list=[];

  Future<List<House>> getHouses(String url) async
  {
    Uri uri=Uri.parse(url + "listings");
    final response = await http.get(uri);
    print("Status: ${response.statusCode}, Body: ${response.body}");
    if(response.statusCode==200)
    {
      var jsResponse=convert.jsonDecode(response.body) as List<Map<String,dynamic>>;
      List<House> list=[];
      for(var elem in jsResponse)
      {
        House h=House.fromMap(elem);
        list.add(h);
      }
      





      List<House> list=codec.decode(response.body)
      .map((object)=>House.fromJson(object))
      .toList();
      return list;
    }
    else return [];
  }

  @override
  Widget build(BuildContext context)
  {
    List<House> _list=[];

    getHouses("https://f825-84-78-248-107.eu.ngrok.io/").then((List<House> value) =>
    {
      updateState(value)
    });

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
          HouseGrid(_list)
        ],
      ),
    );
  }

  void updateState(List<House> value)
  {
    setState(() {
      _list=value;
    });
  }
}
