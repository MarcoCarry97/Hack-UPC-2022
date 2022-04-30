import 'package:flutter/material.dart';

import '../../tools/Singleton.dart';
import '../components/LoginSystem.dart';

class LoginScreen extends StatefulWidget
{
  const LoginScreen({Key? key}) : super(key: key);

  @override
  State<StatefulWidget> createState() {
    return new LoginScreenState();
  }

}

class LoginScreenState extends State<LoginScreen> {

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
  Widget build(BuildContext context) {
    Singleton single=Singleton();
    single.setAppBar(makeAppBar());
    return Scaffold(
      appBar: single.getAppBar(),
      body: Padding(
        padding: EdgeInsets.symmetric(vertical: 0,horizontal: 3),
        child: Center(
          child: LoginSystem()
        ),
      )
    );
  }
}
