import 'package:flutter/material.dart';

import '../../tools/Singleton.dart';

class LoginScreen extends StatefulWidget
{
  const LoginScreen({Key? key}) : super(key: key);

  @override
  State<StatefulWidget> createState() {
    return new LoginScreenState();
  }

}

class LoginScreenState extends State<LoginScreen> {  @override
  Widget build(BuildContext context) {
    Singleton single=Singleton();
    single.setAppBar(AppBar());
    return Center(child: Text("To do!"));
  }
}
