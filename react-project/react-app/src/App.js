import logo from './logo.svg';
import './App.css';
import React, { useState, useEffect } from 'react'
import axios from 'axios';

function App() {
  const [User, setUser] = useState([])
  useEffect(() => {
    // axios.post('/api/users').then(res => {
    //   if(res.data){
    //     // console.log(res.data)
    //     setUser(res.data)
    //   }
    //   else{
    //     alert('failed')
    //     console.log(res.data)
    //   }
    // }).catch(e => {
    //   console.log(e)
    // })
    axios.post('api/users/save').then(res => {
      if(res){
        axios.post('api/users/find').then(res => {
          if(res.data){
            console.log(res.data)
          }
          else{
            alert('failed to find User')
          }
        })
      }
    })
  }, [])

  return (
    <div className="App">
      <header className="App-header">
        <h1>{User.id}</h1>
        <h1>{User.username}</h1>
        <h1>{User.password}</h1>
        <h1>{User.email}</h1>
        
      </header>
    </div>
  );
}

export default App;
