
import 'package:flutter/material.dart';
import 'package:scamslam/widgets/components/searchbar.dart';

import '../../tools/Singleton.dart';

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
  AppBar makeAppBar()
  {
    return AppBar(
      title: Text("ScamSlam"),
      actions: [Padding(padding: EdgeInsets.all(5),
      child: ElevatedButton(
          onPressed: ()=>{},
          child: Icon(Icons.account_circle_outlined,
              color: Colors.red),
          style: ElevatedButton.styleFrom(
              shape: CircleBorder(),
              primary: Colors.white

          )
      ))]
    );
  }

  @override
  Widget build(BuildContext context)
  {
    Singleton single=Singleton();
    single.setAppBar(makeAppBar());
    return Scaffold(appBar: single.getAppBar(),
      floatingActionButton: FloatingActionButton(
        onPressed: ()=>{},
        backgroundColor: Colors.red,
        child: Icon(Icons.add,color: Colors.white,),
      ),
      body: Column(
        children: [
          SearchBar(),
        ],
      ),
    );
  }
}