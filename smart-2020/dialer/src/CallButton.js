import React from "react";
import { View,Image,Pressable } from "react-native";

export const CallButton = ({calling}) => {
  return (
    <View >
       <Pressable onPress={()=>calling()}>
          <Image source={require("../assets/call_on.png")} />
        </Pressable>
    </View>
  );
};
