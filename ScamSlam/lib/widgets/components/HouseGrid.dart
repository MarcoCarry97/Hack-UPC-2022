import 'package:flutter/material.dart';

import '../../classes/House.dart';
//import "package:flutter_staggered_grid_view/flutter_staggered_grid_view.dart";

class HouseGrid extends StatelessWidget
{
  List<House> _houses=List.empty();

  HouseGrid(List<House> houses)
  {
    _houses=houses;
  }

  @override
  Widget build(BuildContext context)
  {
    return Expanded(
        child:GridView(
        gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
          crossAxisCount: 3
        ),
        children: List.generate(_houses.length,
                (index)=> makeTile(_houses[index])
        )
      )
    );
  }

  GridTile makeTile(House house)
  {
    return GridTile(

      child: Padding(
        padding: EdgeInsets.all(5),
        child:FittedBox(
            fit:BoxFit.fill,
            child:Container(
                child: Image.network(house.getImages()[0])
            )
        )
      )
    );
  }
}


