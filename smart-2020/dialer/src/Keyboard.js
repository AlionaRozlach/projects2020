import React from "react";
import { View, Text, StyleSheet, Pressable } from "react-native";

export const Keyboard = ({ onSubmit }) => {
  const pressHandler = () => {
    onSubmit("1");
  };
  const pressHandler2 = () => {
    onSubmit("2");
  }

  const pressHandler3 = () => {
    onSubmit("3");
  };

  const pressHandler4 = () => {
    onSubmit("4");
  };

  const pressHandler5 = () => {
    onSubmit("5");
  };

  const pressHandler6 = () => {
    onSubmit("6");
  };

  const pressHandler7 = () => {
    onSubmit("7");
  };

  const pressHandler8 = () => {
    onSubmit("8");
  };

  const pressHandler9 = () => {
    onSubmit("9");
  };

  const pressHandler0 = () => {
    onSubmit("0");
  };

  const pressStar = () => {
    onSubmit("*");
  };

  const pressLattice = () => {
    onSubmit("#");
  };

  const pressPlus = () => {
    onSubmit("+");
  };

  return (
    <View >
      <View style={styles.buttons}>
        <Pressable onPress={pressHandler}>
          <View style={styles.component}>
            <Text style={styles.text}>1</Text>
          </View>
        </Pressable>
        <Pressable onPress={pressHandler2}>
          <View style={styles.component}>
            <Text style={styles.text}>2</Text>
            <Text style={styles.textLatter}>ABC</Text>
          </View>
        </Pressable>
        <Pressable onPress={pressHandler3}>
          <View style={styles.component}>
            <Text style={styles.text}>3</Text>
            <Text style={styles.textLatter}>DEF</Text>
          </View>
        </Pressable>
      </View>

      <View style={styles.buttons}>
        <Pressable onPress={pressHandler4}>
          <View style={styles.component}>
            <Text style={styles.text}>4</Text>
            <Text style={styles.textLatter}>GHI</Text>
          </View>
        </Pressable>
        <Pressable onPress={pressHandler5}>
          <View style={styles.component}>
            <Text style={styles.text}>5</Text>
            <Text style={styles.textLatter}>JKL</Text>
          </View>
        </Pressable>
        <Pressable onPress={pressHandler6}>
          <View style={styles.component}>
            <Text style={styles.text}>6</Text>
            <Text style={styles.textLatter}>MNO</Text>
          </View>
        </Pressable>
      </View>

      <View style={styles.buttons}>
        <Pressable onPress={pressHandler7}>
          <View style={styles.component}>
            <Text style={styles.text}>7</Text>
            <Text style={styles.textLatter}>PQRS</Text>
          </View>
        </Pressable>
        <Pressable onPress={pressHandler8}>
          <View style={styles.component}>
            <Text style={styles.text}>8</Text>
            <Text style={styles.textLatter}>TUV</Text>
          </View>
        </Pressable>
        <Pressable onPress={pressHandler9}>
          <View style={styles.component}>
            <Text style={styles.text}>9</Text>
            <Text style={styles.textLatter}>WXYZ</Text>
          </View>
        </Pressable>
      </View>

      <View style={styles.buttons}>
        <Pressable onPress={pressStar}>
          <Text style={styles.text}>*</Text>
        </Pressable>
        <Pressable onLongPress={pressPlus} onPress={pressHandler0}>
          <View style={styles.component}>
            <Text style={styles.text}>0</Text>
            <Text style={styles.textLatter}>+</Text>
          </View>
        </Pressable>
        <Pressable onPress={pressLattice}>
          <Text style={styles.text}>#</Text>
        </Pressable>
      </View> 
    </View>
  );
};

const styles = StyleSheet.create({
  component: {
    flexDirection: "column",
    alignItems: "center",
    justifyContent: "center",
  },
  buttons: {
    display: "flex",
    flexDirection: "row",
    justifyContent: "space-around",
    alignItems: "center",
    top: '35%',
    borderColor: "#BDBBBB",
    borderWidth: 1,
  },
  text: {
    fontSize: 30,
  },
  textLatter:{
    fontSize: 17,
  }
});