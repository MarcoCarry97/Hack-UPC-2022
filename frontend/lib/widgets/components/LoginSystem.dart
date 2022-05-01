import 'dart:convert';

import 'package:flutter/material.dart';

import 'package:http/http.dart' as  http;
import 'package:toast/toast.dart';

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
  TextEditingController _emailControl=TextEditingController();
  TextEditingController _pwdControl=TextEditingController();

  @override
  Widget build(BuildContext context)
  {
    ToastContext().init(context);
    return Column(
      children: [
        TextField(
          controller: _emailControl,
        ),
        TextField(
          controller: _pwdControl,
        ),
        TextButton(onPressed: ()
        {
          authentication("https://f825-84-78-248-107.eu.ngrok.io/").then(
            (value) =>
            {

                if(value==0)
                  Navigator.push(context, MaterialPageRoute(builder: (context)=>HomeScreen()))
                else if(value==1)
                {

                  //Toast.show("Incorrect email or password!",
                  //duration:Toast.lengthShort,
                  //gravity:Toast.bottom)
                }
                else
                {
                  //Toast.show("Connect to Internet!",
                  //duration:Toast.lengthShort,
                  //gravity:Toast.bottom)
                }
            });

        },
            child: Text("Enter"))
      ],
    );
  }


    Future<int> authentication(String url) async
    {
      int OK=0;
      int WRONGPWD=1;
      int OTHER=-1;
      String email=_emailControl.text;
      String pwd=_pwdControl.text;
      Uri uri=Uri.parse(url + "auth");
      http.Response response=await http.get(
          Uri.parse('https://reqres.in/api/users'),
          headers: <String, String>{
            'Content-Type': 'application/json; charset=UTF-8',
          },
          /*body: jsonEncode(<String, String>{
            'email': email,
            'encodedPassword': pwd
          })*/);
      print("email: $email pwd: $pwd");
      print(response.statusCode);
      if(response.statusCode==200)
        return OK;
      else if(response.statusCode==401)
        return WRONGPWD;
      else return OTHER;
  }


}