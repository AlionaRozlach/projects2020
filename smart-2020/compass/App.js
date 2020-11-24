import React, { useState,useEffect } from 'react';
import { StyleSheet, Text, View, Image, Pressable } from 'react-native';
import { Magnetometer } from 'expo-sensors';

export default function App() {
  const [data, setData] = useState(0);
  const [magnetometer, setMagnetometer] = useState([0,0]);
  


  useEffect(()=>{
      Magnetometer.setUpdateInterval(700);
      Magnetometer.addListener((result) => {
        setMagnetometer([result.x,result.y]);
      });

    return () =>{
      _unsubscribe();
    };
  },[]);


 const _unsubscribe = ()=>{
    Magnetometer.removeAllListeners(); 
  };
  const _angle=()=>{
    if ((angle = Math.atan2(magnetometer[0], magnetometer[1])) >= 0)
     setData(Math.round(angle*180/Math.PI));
     else
     setData(Math.round(angle*180/Math.PI + 360));
   }

  useEffect(()=>{
    _angle();
  },[magnetometer]);

  return (
    <View style={styles.container} >
    <View style={styles.objects}>
   <Image  style={[
      {transform: [{ rotateZ: data +'deg' }]},
    ]}

     source={require('./assets/compass.png')}/>
    <View>
      <Text style={styles.text}>
        {data}
      </Text>
      </View></View>
   </View>
        
     

  );
};


const styles = StyleSheet.create({
  container: {
    flexDirection:"column",
    alignItems:'stretch',
    flex:1,
  },

  text:{
    fontSize: 30,
    fontWeight:"bold",
    top:"90%"
  },objects:{
    height:"70%",
    flex:1,
    justifyContent:"center",
    alignItems:"center"
  }
});




