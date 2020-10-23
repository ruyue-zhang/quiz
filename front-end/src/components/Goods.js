import React, { Component } from 'react';
import Good from './Good';
import '../style/Goods.css'

class Goods extends Component {
  state = {
    goods: [],
  };
 
  getGoods = async () => {
    fetch("http://localhost:8080/goods").then(response => {
      if(response.status === 200) {
        return response.json()
      } else {
        Promise.reject('get goods error!')
      }
    }).then(data => {
      console.log(data)
      this.setState({
        goods: data
      });
    }).catch(err => {
      console.log(err)
    });
  }

  componentDidMount() {
    this.getGoods();
  }

  render() {
    const { goods } = this.state;
    return (
      <div class="container" id="container">
        {goods.map(good => (
          <Good key={good.id} good={good} />
        ))}
      </div>
    );
  }
}

export default Goods;