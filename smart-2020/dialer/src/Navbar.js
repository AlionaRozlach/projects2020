import React from "react";
import { View, Text, StyleSheet } from "react-native";

export const Navbar = (props) => {
  return (
    <View style={styles.navbar}>
      <Text style={styles.text}>Phone</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  navbar: {
    height: 90,
    alignItems: "flex-start",
    justifyContent: "flex-start",
    backgroundColor: "#29C337",
  },
  text: {
    fontSize: 20,
    marginLeft: 23,
    marginTop: 23,
    color: "white",
  },
});
