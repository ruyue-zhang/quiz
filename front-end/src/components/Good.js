import React, { Component } from 'react';
import '../style/Good.css';

class Good extends Component {
  render() {
    const { name, price, unitOfMeasurement, img } = this.props.good;
    return (
      <div class="col mb-4">
        <div class="card">
          <img src={img} class="card-img-top" alt="goods_img"/>
          <div class="card-body">
            <h5 class="card-title">{name}</h5>
            <p class="card-text">单价：{price}元/{unitOfMeasurement}</p>
          </div>
          <button>十</button>
        </div>
      </div>
    );
  }
}

export default Good;