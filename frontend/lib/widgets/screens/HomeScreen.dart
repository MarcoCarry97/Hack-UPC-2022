
import 'package:flutter/material.dart';
import 'package:scamslam/widgets/components/HouseGrid.dart';
import 'package:scamslam/widgets/components/searchbar.dart';

import '../../classes/House.dart';
import '../../tools/Singleton.dart';

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


  @override
  Widget build(BuildContext context)
  {

    List<House> list=[];
    for(int i=0;i<=10;i++)
    {
      House h=House("Sample","",0);
      h.addImage("https://mymodernmet.com/wp/wp-content/uploads/2017/03/gabrielius-khiterer-stray-cats-11.jpg");
      list.add(h);
    }
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