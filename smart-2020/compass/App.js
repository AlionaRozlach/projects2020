import React, { useState, useEffect } from 'react';
import { StyleSheet, Text, TouchableOpacity, View, Image } from 'react-native';
import { Accelerometer } from 'expo-sensors';

export default function App() {

  const [data, setData] = useState({});

  useEffect(() => {
    _toggle();
  }, []);

  useEffect(() => {
    return () => {
      _unsubscribe();
    };
  }, []);

  const _toggle = () => {
    if (this._subscription) {
      _unsubscribe();
    } else {
      _subscribe();
    }
  };

  const _subscribe = () => {
    this._subscription = Accelerometer.addListener(accelerometerData => {
      setData(compassHeading(accelerometerData.z, accelerometerData.x, accelerometerData.y));
    });
  };

  const _unsubscribe = () => {
    this._subscription && this._subscription.remove();
    this._subscription = null;
  };



  var degtorad = Math.PI / 180; // Degree-to-Radian conversion

  function compassHeading( alpha, beta, gamma ) {
  
    var _x = beta  ? beta  * degtorad : 0; // beta value
    var _y = gamma ? gamma * degtorad : 0; // gamma value
    var _z = alpha ? alpha * degtorad : 0; // alpha value
  
    var cX = Math.cos( _x );
    var cY = Math.cos( _y );
    var cZ = Math.cos( _z );
    var sX = Math.sin( _x );
    var sY = Math.sin( _y );
    var sZ = Math.sin( _z );
  
    // Calculate Vx and Vy components
    var Vx = - cZ * sY - sZ * sX * cY;
    var Vy = - sZ * sY + cZ * sX * cY;
  
    // Calculate compass heading
    var compassHeading = Math.atan( Vx / Vy );
  
    // Convert compass heading to use whole unit circle
    if( Vy < 0 ) {
      compassHeading += Math.PI;
    } else if( Vx < 0 ) {
      compassHeading += 2 * Math.PI;
    }
  
    return compassHeading * ( 180 / Math.PI );
        // Compass Heading (in degrees)
  }

  function round(n) {
    if (!n) {
      return 0;
    }
  
    return Math.floor(n * 100) / 100;
  }


  return (
    <View style={styles.container} >
      <View style={styles.objects}>
     <Image  style={[
        {transform: [{rotate: `${360 - data}deg`}]},
      ]}

       source={require('./assets/compass.png')}/>
      <View>
        <Text style={styles.text}>
          {round(data)}
        </Text>
        </View></View>
     </View>
  );
}


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