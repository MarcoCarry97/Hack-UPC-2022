import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class SearchBar extends StatefulWidget
{
  const SearchBar({Key? key}) : super(key: key);

  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return SearchBarState();
  }

}

class SearchBarState extends State<SearchBar>
{
  @override
  Widget build(BuildContext context) {
    return Padding( child: Row(
      children:[
        Expanded(child:TextField(
          decoration: InputDecoration(
              hintText: "Search Here!"
          ),
        )),
        TextButton(onPressed: ()=>{},child: Icon(Icons.filter),
        ),
        TextButton(onPressed: ()=>{},child: Icon(Icons.search),),
        TextButton(onPressed: ()=>{}, child: Icon(Icons.image_search))
      ],


        ),
        padding: EdgeInsets.all(5),
    );
  }

}