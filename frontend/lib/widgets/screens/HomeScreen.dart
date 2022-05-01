



//import 'dart:js';

import 'package:flutter/material.dart';
import 'package:scamslam/widgets/components/HouseGrid.dart';
import 'package:scamslam/widgets/components/searchbar.dart';
import "package:http/http.dart" as http;

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

  List<House> list=[];
  bool _checked=false;
  TextEditingController searchControl=TextEditingController();

  Future<List<House>> getHouses(String url) async
  {
    Uri uri=Uri.parse(url + "listings");
    final response = await http.get(uri);
    print("Status: ${response.statusCode}, Body: ${response.body}");
    if(response.statusCode==200)
    {
      var codec=JsonCodec();
      var js= codec.decode(response.body) as List<dynamic>;

      List<House> list=[];
      for(dynamic elem in js)
      {
        House h=House.fromJson(elem as Map<String,dynamic>);
        list.add(h);
      }
      // .toList() as List<House>;
      return list;
    }
    else return [];
  }

  @override
  Widget build(BuildContext context)
  {
    if(!_checked)
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
          makeSearchBar(),
          HouseGrid(this.list)
        ],
      ),
    );
  }

  void updateState(List<House> value)
  {
    setState(() {
        list=value;
      _checked=true;
    });
  }

  Padding makeSearchBar()
  {
    return Padding( child: Row(
      children:[
        Expanded(child:TextField(
          controller: searchControl,
          decoration: InputDecoration(
              hintText: "Search Here!"
          ),
        )),
        TextButton(onPressed: ()=>{},child: Icon(Icons.filter),
        ),
        TextButton(onPressed: ()=>{
          textSearch(searchControl.text).then((value)=>
              updateState(value)
          )
        },child: Icon(Icons.search),),
        TextButton(onPressed: ()=>{}, child: Icon(Icons.image_search))
      ],


    ),
      padding: EdgeInsets.all(5),
    );
  }

  Future<List<House>> textSearch(String searchString) async
  {
    String url="https://f825-84-78-248-107.eu.ngrok.io/";
    Uri uri=Uri.parse(url + "search-listings/"+searchString);
    final response = await http.get(uri);
    print("Status: ${response.statusCode}, Body: ${response.body}");
    if(response.statusCode==200)
    {
      var codec=JsonCodec();
      var js= codec.decode(response.body) as List<dynamic>;

      List<House> list=[];
      for(dynamic elem in js)
      {
        House h=House.fromJson(elem as Map<String,dynamic>);
        list.add(h);
      }
      // .toList() as List<House>;
      return list;
    }
    else return [];
  }
}
