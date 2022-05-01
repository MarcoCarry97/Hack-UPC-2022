import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import "package:http/http.dart" as http;

import '../../classes/House.dart';

class SearchBar extends StatefulWidget
{

  final SearchBarState state=SearchBarState();

  SearchBar({Key? key}) : super(key: key);


  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return state;
  }

  List<House> getList()
  {
    return state.list;
  }
}

class SearchBarState extends State<SearchBar>
{
  TextEditingController searchControl=TextEditingController();

  List<House> list=[];

  @override
  Widget build(BuildContext context) {
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

  void updateState(value)
  {
    setState(() {
      list=value;
    });
  }

}