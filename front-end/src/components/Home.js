import React, { Component } from 'react';
import '../style/Home.css'

class Home extends Component {
  render() {
    const { name, price, unit, img, onAdd } = this.props;
    return (
      <div className="goods">
        <img src={img} alt="goods_img"/>
        <div className="buy">
          <span className="name">{name}</span>
          <span className="price">单价：{price}元/{unit}</span>
          <button onClick={onAdd}>+</button>
        </div>
      </div>
    );
  }
}

export default Home;