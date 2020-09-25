import React, { Component } from 'react';
import '../style/Home.css';
import apple from '../apple.jpg';

class Home extends Component {
  state = {
    name: "苹果",
    price: 2,
    unitOfMeasurement: "斤",
    img: apple,
  }
  render() {
    // const { name, price, unit, img, onAdd } = this.props;
    return (
      <div className="goods">
        <img src={this.state.img} alt="goods_img"/>
        <div className="buy">
          <span className="name">{this.state.name}</span>
          <span className="price">单价：{this.state.price}元/{this.state.unitOfMeasurement}</span>
        </div>
        <button>+</button>
      </div>
    );
  }
}

export default Home;