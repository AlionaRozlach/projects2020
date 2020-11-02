import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { StyleSheet, Text, View, TouchableOpacity,Image, Pressable } from 'react-native';
import  { useState } from "react";

import { Navbar } from "./src/Navbar";
import { Keyboard } from "./src/Keyboard.js";
import {DeleteButton} from "./src/DeleteButton"
import call from "react-native-phone-call";
import { CallButton } from './src/CallButton';

export default function App() {

  const [isPressed, setIsPressed] = useState("");

   var buttonDelete;  
  const onPressButton = (num) => {
    if (isPressed.length > 9) {
      setIsPressed("");
    } else {
      if(num==="+")
      {
        if(isPressed.length!=0)
        {
          num="0";
        }
        else{
          setIsPressed(isPressed + num);
        }
        setIsPressed(isPressed + num);
      }
      else{
        setIsPressed(isPressed + num);
      }
      
    }
    console.log(isPressed); 
  };

  const pressDelete = () => {
    if (isPressed.length > 0) {
      setIsPressed(isPressed.substring(0, isPressed.length - 1));
    }
    console.log(isPressed);
  };


  const pressDeleteAll = () => {
    if (isPressed.length > 0) {
      setIsPressed("");
    }
  
  };

  const pressCall = () => {
      const args = {
        number: isPressed, // String value with the number to call
        prompt: false, // Optional boolean property. Determines if the user should be prompt prior to the call
      }
      call(args).catch(console.error);

    
  };

  if(isPressed.length>0)
    {
      buttonDelete= <DeleteButton deletePhoneNum={pressDeleteAll} deleteNum = {pressDelete}/>
    }
  return (
    <View >
     <Navbar/>

    <View>
     <Text  style={styles.output}>{isPressed}</Text>
      <Keyboard onSubmit={onPressButton} />
      <View style={styles.call}><CallButton calling ={pressCall}/></View>
      
      </View>
     {buttonDelete}
    
    </View>
  );
}

const styles = StyleSheet.create({
  
   output: {

    top:'30%',
    justifyContent:'center',
    alignItems:'center',
    fontSize: 50,
    textAlign: "center",
    fontWeight: "bold",
    textAlignVertical: "center",
    // lineHeight: 50,
  },
  call:{
    flexDirection: "row",
    justifyContent: "center",
    alignItems: "flex-end",
    top:"45%",
}
});
