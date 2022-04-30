import 'package:flutter/material.dart';

import '../screens/HomeScreen.dart';

class LoginSystem extends StatefulWidget
{

  const LoginSystem({Key? key}) : super(key: key);

  @override
  State<StatefulWidget> createState() {
    return LoginSystemState();
  }

}

class LoginSystemState extends State<LoginSystem>
{
  @override
  Widget build(BuildContext context)
  {
    return Column(
      children: [
        TextField(),
        TextField(),
        TextButton(onPressed: ()
        {
          Navigator.push(context, MaterialPageRoute(builder: (BuildContext context)
          {
            return HomeScreen();
          }));
        },
            child: Text("Enter"))
      ],
    );
  }

}