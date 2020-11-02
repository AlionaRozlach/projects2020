import React, { useState } from "react";
import { View,  StyleSheet, TouchableOpacity,Image } from "react-native";

export const DeleteButton = ({ deleteNum, deletePhoneNum}) => {
  return (
    <View >
      <TouchableOpacity style={styles.delete} onLongPress={deletePhoneNum} onPress={deleteNum}>
          <Image source={require("../assets/backspace.png")} />
        </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
 delete: {
    flexDirection:'row',
    justifyContent:'flex-end',
    alignItems:'center',
    bottom:'65%'
  },
});